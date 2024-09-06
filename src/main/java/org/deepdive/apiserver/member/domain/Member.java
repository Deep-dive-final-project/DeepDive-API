package org.deepdive.apiserver.member.domain;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Member {

    private Long memberId;
    private String name;
    private String email;
    private String password;
    private String role;
}
