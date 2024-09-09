package org.deepdive.apiserver.security.application.service;

import lombok.RequiredArgsConstructor;
import org.deepdive.apiserver.security.application.interfaces.MemberRepository;
import org.deepdive.apiserver.security.domain.Member;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    public Member getMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
