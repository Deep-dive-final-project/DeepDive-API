package org.deepdive.apiserver.security.controller;

import lombok.RequiredArgsConstructor;
import org.deepdive.apiserver.common.dto.CommonSuccessDto;
import org.deepdive.apiserver.security.dto.request.SignupDto;
import org.deepdive.apiserver.security.service.AuthService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthService authService;

    @PostMapping("/signup")
    public CommonSuccessDto signup(@RequestBody SignupDto signupDto) {
        authService.saveMember(signupDto);
        return CommonSuccessDto.fromEntity(true);
    }
}
