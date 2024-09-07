package org.deepdive.apiserver.security.application.interfaces;

import org.deepdive.apiserver.security.domain.Member;

public interface MemberRepository {

    Member findByEmail(String email);

    void save(Member member);

    boolean isExist(String email);

    Member findById(Long memberId);
}
