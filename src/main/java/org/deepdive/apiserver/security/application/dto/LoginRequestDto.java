package org.deepdive.apiserver.security.application.dto;

public record LoginRequestDto(String email,
                              String password) {
}
