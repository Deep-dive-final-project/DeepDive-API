package org.deepdive.apiserver.security.application;

import static org.deepdive.apiserver.common.exception.ErrorCode.ALREADY_EXIST_MEMBER;

import lombok.RequiredArgsConstructor;
import org.deepdive.apiserver.common.exception.CommonException;
import org.deepdive.apiserver.security.application.dto.request.SignupDto;
import org.deepdive.apiserver.security.application.interfaces.MemberRepository;
import org.deepdive.apiserver.security.domain.Member;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final MemberRepository memberRepository;

    public void saveMember(SignupDto dto) {
        boolean memberExist = memberRepository.isExist(dto.email());
        if (memberExist) {
            throw new CommonException(ALREADY_EXIST_MEMBER);
        }

        Member member = Member.signUp(dto.email(), dto.username(), dto.password());
        memberRepository.save(member);
    }
}
