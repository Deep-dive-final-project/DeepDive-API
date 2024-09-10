package org.deepdive.apiserver.security.application.dto;


import static org.deepdive.apiserver.security.utils.SecurityConst.TOKEN_PREFIX;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;

@Builder
public record JwtResponseDto(@JsonProperty("access_token") String accessToken,
                             @JsonProperty("refresh_token") String refreshToken) {

    public static JwtResponseDto fromEntity(String accessToken, String refreshToken) {
        return new JwtResponseDto(
                TOKEN_PREFIX + accessToken,
                refreshToken);
    }
}
