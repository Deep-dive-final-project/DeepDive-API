package org.deepdive.apiserver.security.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import org.deepdive.apiserver.security.dto.request.SignupDto;

@Entity
@Getter
@Table(name = "member")
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long id;

    @Column(length = 100, nullable = false)
    private String name;

    @Column(length = 255, nullable = false, unique = true)
    private String email;

    @Column(length = 255, nullable = false)
    private String password;

    @Column(length = 50, nullable = false)
    private String role;

    public static Member createMember(SignupDto dto) {
        Member member = new Member();
        member.email = dto.email();
        member.name = dto.username();
        member.password = dto.password();
        member.role = "ROLE_USER";

        return member;
    }
}
