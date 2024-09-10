package org.deepdive.apiserver.security.ui;

import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.deepdive.apiserver.common.dto.CommonSuccessDto;
import org.deepdive.apiserver.common.dto.ResponseDto;
import org.deepdive.apiserver.security.application.dto.JwtResponseDto;
import org.deepdive.apiserver.security.application.dto.LoginRequestDto;
import org.deepdive.apiserver.security.application.dto.SignupRequestDto;
import org.deepdive.apiserver.security.application.service.SimpleAuthenticationService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/auth")
public class SimpleAuthenticationController {

    private final SimpleAuthenticationService simpleAuthenticationService;

    /**
     * 토큰 없이 로그인 시도
     */
    @PostMapping("/login")
    public ResponseDto<JwtResponseDto> signIn(@RequestBody LoginRequestDto dto) {
        return ResponseDto.ok(simpleAuthenticationService.login(dto));
    }

    /**
     * 토큰을 이용한 회원가입 시도
     */
    @PostMapping("/signup")
    public CommonSuccessDto signUp(@RequestBody SignupRequestDto dto) {
        return simpleAuthenticationService.signup(dto);
    }
}
