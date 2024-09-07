package org.deepdive.apiserver.plan.repository.jpa;

import io.lettuce.core.dynamic.annotation.Param;
import java.util.List;
import java.util.Optional;
import org.deepdive.apiserver.plan.domain.Plan;
import org.deepdive.apiserver.plan.repository.entity.PlanEntity;
import org.deepdive.apiserver.security.repository.entity.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface JpaPlanRepository extends JpaRepository<PlanEntity, Long> {

    @Query("select p from PlanEntity p" +
            " join fetch p.memberEntity m"+
            " where m.memberId = :memberId")
    List<PlanEntity> findAllByMember(@Param("memberId")Long memberId);

    @Query("select p from PlanEntity p"+
            " join fetch p.memberEntity m"+
            " where m.memberId = :memberId"+
            " and p.planId = :planId")
    Plan findByIdAndMemberId(@Param("memberId")Long memberId, @Param("planId")Long planId);

    @Query("select p from PlanEntity p"+
            " join fetch p.memberEntity m"+
            " where p.planId = :planId")
    Optional<PlanEntity> findById(@Param("planId") Long planId);

    void delete(PlanEntity plan);
}
