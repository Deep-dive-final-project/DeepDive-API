package org.deepdive.apiserver.member.repository.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.deepdive.apiserver.member.domain.Member;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class MemberEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private long memberId;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "role")
    private String role;

    public MemberEntity(Member member){
        memberId = member.getMemberId();
        name = member.getName();
        email = member.getEmail();
        password = member.getPassword();
        role = member.getRole();
    }

    public Member toMember(){
        return Member.builder()
                .memberId(memberId)
                .name(name)
                .email(email)
                .password(password)
                .role(role)
                .build();
    }
}
