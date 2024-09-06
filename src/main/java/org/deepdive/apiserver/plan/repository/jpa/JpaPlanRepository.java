package org.deepdive.apiserver.plan.repository.jpa;

import java.util.List;
import org.deepdive.apiserver.member.domain.Member;
import org.deepdive.apiserver.plan.repository.entity.PlanEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaPlanRepository extends JpaRepository<PlanEntity, Long> {

    List<PlanEntity> findAllByMember(Member member);
}
