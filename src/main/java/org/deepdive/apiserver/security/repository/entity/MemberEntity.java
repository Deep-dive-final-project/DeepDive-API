package org.deepdive.apiserver.security.repository.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.deepdive.apiserver.security.domain.Member;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "member")
public class MemberEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long memberId;

    @Column(length = 100, nullable = false)
    private String name;

    @Column(length = 255, nullable = false, unique = true)
    private String email;

    @Column(length = 255, nullable = false)
    private String password;

    @Column(length = 50, nullable = false)
    private String role;

    public MemberEntity(Member member) {
        this.memberId = member.getMemberId();
        this.name = member.getUsername();
        this.email = member.getEmail();
        this.password = member.getPassword();
        this.role = member.getRole();
    }

    public Member toMember() {
        return Member.builder()
            .memberId(memberId)
            .username(name)
            .email(email)
            .password("{noop}" + password)
            .role(role)
            .build();
    }
}
