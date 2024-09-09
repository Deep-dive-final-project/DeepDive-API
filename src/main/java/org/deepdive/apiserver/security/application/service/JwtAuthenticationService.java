package org.deepdive.apiserver.security.application.service;

import static org.deepdive.apiserver.common.exception.ErrorCode.EXPIRED_REFRESH_TOKEN_ERROR;
import static org.deepdive.apiserver.security.utils.SecurityConst.ACCESS_TOKEN_VALIDITY_IN_MILLISECONDS;
import static org.deepdive.apiserver.security.utils.SecurityConst.SECRET;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import java.security.Key;
import java.util.Date;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.deepdive.apiserver.common.dto.CommonSuccessDto;
import org.deepdive.apiserver.common.exception.CommonException;
import org.deepdive.apiserver.security.application.dto.JwtAccessTokenResponseDto;
import org.deepdive.apiserver.security.repository.BlackListRepository;
import org.deepdive.apiserver.security.repository.RefreshTokenRepository;
import org.deepdive.apiserver.security.repository.entity.BlackList;
import org.deepdive.apiserver.security.repository.entity.RefreshToken;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class JwtAuthenticationService implements InitializingBean {

    private final RefreshTokenRepository refreshTokenRepository;
    private final BlackListRepository blackListRepository;

    @Getter
    private static Key key;

    @Override
    public void afterPropertiesSet() {
        byte[] keyBytes = Decoders.BASE64.decode(SECRET);
        key = Keys.hmacShaKeyFor(keyBytes);
    }

    /**
     * SimpleAuthenticatoinService에서 accessToken 생성 nickname과 password 이용
     */
    public String createAccessToken(Authentication authentication) {
        CustomUserDetails principal = (CustomUserDetails) authentication.getPrincipal();
        Long memberId = principal.getId();
        return getAccessToken(memberId);
    }

    /**
     * refreshToken을 이용해 accessToken 생성
     */
    public JwtAccessTokenResponseDto createAccessToken(String refreshToken) {
        RefreshToken findRefreshToken = refreshTokenRepository.findById(refreshToken)
                .orElseThrow(() -> new CommonException(EXPIRED_REFRESH_TOKEN_ERROR));

        String accessToken = getAccessToken(findRefreshToken.getUserId());
        return JwtAccessTokenResponseDto.fromEntity(accessToken);
    }

    private String getAccessToken(Long memberId) {
        long now = (new Date()).getTime();
        Date accessTokenValidity = new Date(now + ACCESS_TOKEN_VALIDITY_IN_MILLISECONDS);

        return Jwts.builder()
                .signWith(key, SignatureAlgorithm.HS512)
                .setHeaderParam("typ", "JWT")
                .setSubject(String.valueOf(memberId))
                .setExpiration(accessTokenValidity)
                .setIssuedAt(new Date())
                .compact();
    }

    public RefreshToken createRefreshToken(Authentication authentication) {
        CustomUserDetails principal = (CustomUserDetails) authentication.getPrincipal();
        Long memberId = principal.getId();

        String token = Jwts.builder()
                .signWith(key, SignatureAlgorithm.HS512)
                .setSubject(String.valueOf(memberId))
                .compact();
        RefreshToken refreshToken = RefreshToken.createRefreshToken(token, memberId);
        // redis에 refresh token 저장
        refreshTokenRepository.save(refreshToken);

        return refreshToken;
    }

    public CommonSuccessDto deleteRefreshAndAccessToken(String accessToken, String refreshToken) {
        // refreshToken 삭제
        refreshTokenRepository.deleteById(refreshToken);

        // accessToken 블랙 처리
        BlackList blackListToken = BlackList.createBlackList(accessToken);
        blackListRepository.save(blackListToken);

        return CommonSuccessDto.fromEntity(true);
    }

    /**
     * oauth jwt token 생성
     */
    public String createAccessTokenForOAuth(Long memberId) {
        return getAccessToken(memberId);
    }

    public RefreshToken createRefreshTokenForOAuth(Long memberId) {
        String token = Jwts.builder()
                .signWith(key, SignatureAlgorithm.HS512)
                .setSubject(String.valueOf(memberId))
                .compact();
        RefreshToken refreshToken = RefreshToken.createRefreshToken(token, memberId);

        refreshTokenRepository.save(refreshToken);

        return refreshToken;
    }
}
