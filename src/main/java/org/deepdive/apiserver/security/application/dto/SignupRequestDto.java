package org.deepdive.apiserver.security.application.dto;

public record SignupRequestDto(
        String username,
        String password,
        String email
) {
}
