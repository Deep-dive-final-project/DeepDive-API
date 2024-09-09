package org.deepdive.apiserver.security.application.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record JwtAccessTokenResponseDto(
        @JsonProperty("access_token") String accessToken
) {
    public static JwtAccessTokenResponseDto fromEntity(String accessToken) {
        return new JwtAccessTokenResponseDto(accessToken);
    }
}
