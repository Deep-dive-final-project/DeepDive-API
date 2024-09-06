package org.deepdive.apiserver.security.repository;

import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.deepdive.apiserver.common.exception.CommonException;
import org.deepdive.apiserver.common.exception.ErrorCode;
import org.deepdive.apiserver.security.application.interfaces.MemberRepository;
import org.deepdive.apiserver.security.domain.Member;
import org.deepdive.apiserver.security.repository.entity.MemberEntity;
import org.deepdive.apiserver.security.repository.jpa.JpaMemberRepository;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class MemberRepositoryImpl implements MemberRepository {

    private final JpaMemberRepository memberRepository;

    @Override
    public Member findByEmail(String email) {
        MemberEntity entity = memberRepository.findByEmail(email)
            .orElseThrow(() -> new CommonException(ErrorCode.NOT_FOUND_MEMBER));
        return entity.toMember();
    }

    @Override
    public void save(
        org.deepdive.apiserver.security.domain.Member member) {
        MemberEntity entity = memberRepository.save(new MemberEntity(member));
    }

    @Override
    public boolean isExist(String email) {
        Optional<MemberEntity> member = memberRepository.findByEmail(email);
        return member.isPresent();
    }
}
