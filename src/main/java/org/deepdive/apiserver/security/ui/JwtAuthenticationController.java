package org.deepdive.apiserver.security.ui;

import static org.deepdive.apiserver.security.utils.SecurityConst.REFRESH;
import static org.springframework.http.HttpHeaders.AUTHORIZATION;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.deepdive.apiserver.common.dto.CommonSuccessDto;
import org.deepdive.apiserver.common.dto.ResponseDto;
import org.deepdive.apiserver.security.application.dto.JwtAccessTokenResponseDto;
import org.deepdive.apiserver.security.application.service.JwtAuthenticationService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class JwtAuthenticationController {

    private final JwtAuthenticationService jwtAuthenticationService;

    /**
     * refreshToken을 이용해 accessToken 발급
     */
    @PostMapping("/access-reissue")
    public ResponseDto<JwtAccessTokenResponseDto> reIssueAccessToken(HttpServletRequest request) {
        String refreshToken = request.getHeader(AUTHORIZATION);
        JwtAccessTokenResponseDto accessToken = jwtAuthenticationService.createAccessToken(refreshToken);
        return ResponseDto.ok(accessToken);
    }

    @PostMapping("/logout")
    public ResponseDto<CommonSuccessDto> logOut(@RequestHeader(AUTHORIZATION) String accessToken,
                                                @RequestHeader(REFRESH) String refreshToken) {
        return ResponseDto.ok(jwtAuthenticationService.deleteRefreshAndAccessToken(accessToken, refreshToken));
    }
}
