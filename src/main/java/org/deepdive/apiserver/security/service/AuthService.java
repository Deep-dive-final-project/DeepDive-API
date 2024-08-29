package org.deepdive.apiserver.security.service;

import static org.deepdive.apiserver.exception.ErrorCode.ALREADY_EXIST_MEMBER;

import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.deepdive.apiserver.exception.CommonException;
import org.deepdive.apiserver.security.dto.request.SignupDto;
import org.deepdive.apiserver.security.entity.Member;
import org.deepdive.apiserver.security.repository.MemberRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final MemberRepository memberRepository;

    public void saveMember(SignupDto dto) {
        Optional<Member> findMember = memberRepository.findByEmail(dto.email());
        if (findMember.isPresent()) {
            throw new CommonException(ALREADY_EXIST_MEMBER);
        }
        Member member = Member.createMember(dto);
        memberRepository.save(member);
    }
}
