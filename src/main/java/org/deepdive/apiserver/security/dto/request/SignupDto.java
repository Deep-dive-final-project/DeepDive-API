package org.deepdive.apiserver.security.dto.request;

public record SignupDto(
    String username,
    String email,
    String password
) {

}
