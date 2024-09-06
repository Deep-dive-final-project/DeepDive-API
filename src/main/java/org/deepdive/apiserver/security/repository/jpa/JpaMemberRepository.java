package org.deepdive.apiserver.security.repository.jpa;

import java.util.Optional;
import org.deepdive.apiserver.security.repository.entity.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaMemberRepository extends JpaRepository<MemberEntity, Long> {

    Optional<MemberEntity> findByEmail(String email);
}
