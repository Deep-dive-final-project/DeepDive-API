package org.deepdive.apiserver.security.application.service;

import lombok.RequiredArgsConstructor;
import org.deepdive.apiserver.common.dto.CommonSuccessDto;
import org.deepdive.apiserver.security.application.dto.JwtResponseDto;
import org.deepdive.apiserver.security.application.dto.LoginRequestDto;
import org.deepdive.apiserver.security.application.dto.SignupRequestDto;
import org.deepdive.apiserver.security.application.provider.SimpleAuthenticationProvider;
import org.deepdive.apiserver.security.domain.Member;
import org.deepdive.apiserver.security.repository.entity.RefreshToken;
import org.deepdive.apiserver.security.application.interfaces.MemberRepository;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class SimpleAuthenticationService {

    private final JwtAuthenticationService jwtAuthenticationService;
    private final SimpleAuthenticationProvider simpleAuthenticationProvider;
    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;

    /**
     * 토큰이 없는 사용자는 SimpleAuthenticationProvider가 검증을 하고 검증에 성공하면 Jwt Token을 생성해서 반환
     */
    public JwtResponseDto login(LoginRequestDto dto) {
        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
                dto.email(),
                dto.password());

        // username과 password를 검증
        Authentication authenticate = simpleAuthenticationProvider.authenticate(authentication);

        // username과 password를 이용해 token 생성
        String accessToken = jwtAuthenticationService.createAccessToken(authenticate);
        RefreshToken refreshToken = jwtAuthenticationService.createRefreshToken(authenticate);

        return JwtResponseDto.fromEntity(accessToken, refreshToken.getToken());
    }

    /**
     * 회원 가입
     */
    @Transactional
    public CommonSuccessDto signup(SignupRequestDto dto) {
//        String encodedPassword = passwordEncoder.encode(dto.password());

        Member member = Member.signUp(dto.email(), dto.username(), dto.password());
        memberRepository.save(member);

        return CommonSuccessDto.fromEntity(true);
    }
}
