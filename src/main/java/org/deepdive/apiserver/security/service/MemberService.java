package org.deepdive.apiserver.security.service;

import lombok.RequiredArgsConstructor;
import org.deepdive.apiserver.common.exception.CommonException;
import org.deepdive.apiserver.common.exception.ErrorCode;
import org.deepdive.apiserver.security.entity.Member;
import org.deepdive.apiserver.security.repository.MemberRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    public Member getMember(Long memberId){
        return memberRepository.findById(memberId).orElseThrow(() -> new CommonException(ErrorCode.NOT_FOUND_MEMBER));
    }
}
