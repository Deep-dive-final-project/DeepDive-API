package org.deepdive.apiserver.security.application.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record ReIssueAccessTokenRequestDto(
    @JsonProperty("refresh_token")
    String refreshToken
) {

    public ReIssueAccessTokenRequestDto(@JsonProperty("refresh_token")
    String refreshToken) {
        this.refreshToken = refreshToken;
    }
}
