package org.deepdive.apiserver.security.repository.entity;


import static org.deepdive.apiserver.security.utils.SecurityConst.REFRESH_TOKEN_VALIDITY_IN_SECONDS;

import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

@Getter
@RedisHash(value = "refreshToken", timeToLive = REFRESH_TOKEN_VALIDITY_IN_SECONDS)
public class RefreshToken {

    @Id
    private String token;
    private Long userId;

    public static RefreshToken createRefreshToken(String refreshToken, Long userId) {
        RefreshToken token = new RefreshToken();
        token.token = refreshToken;
        token.userId = userId;
        return token;
    }
}
