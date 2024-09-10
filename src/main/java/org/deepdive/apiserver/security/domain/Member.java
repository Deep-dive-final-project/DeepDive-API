package org.deepdive.apiserver.security.domain;

import java.io.Serializable;

import lombok.*;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Member implements Serializable {

    private static final long serialVersionUID = 1L; // 직렬화 버전 UID

    private Long memberId;
    private String email;
    private String username;
    private String password;
    private String role;

    public static Member signUp(String email, String username, String password) {
        Member member = new Member();
        member.email = email;
        member.username = username;
        member.password = password;
        member.role = "ROLE_USER";

        return member;
    }
}
