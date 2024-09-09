package org.deepdive.apiserver.security.application.dto;

public record JwtRefreshTokenDto(
        String refreshToken
) {
    public static JwtRefreshTokenDto fromEntity(String refreshToken) {
        return new JwtRefreshTokenDto(refreshToken);
    }
}
