package org.deepdive.apiserver.security.application.dto.request;

public record SignupDto(
    String username,
    String email,
    String password
) {

}
