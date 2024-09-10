package org.deepdive.apiserver.plan.repository.jpa;

import java.util.List;
import org.deepdive.apiserver.plan.repository.entity.PlanEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface JpaPlanRepository extends JpaRepository<PlanEntity, Long> {

    @Query("select p from PlanEntity p" +
            " join fetch p.memberEntity m"+
            " where m.memberId = :memberId")
    List<PlanEntity> findAllByMember(@Param("memberId")Long memberId);

    @Query("select p from PlanEntity p"+
            " join fetch p.memberEntity m"+
            " where m.memberId = :memberId"+
            " and p.planId = :planId")
    PlanEntity findByIdAndMemberId(@Param("memberId")Long memberId, @Param("planId")Long planId);

    void delete(PlanEntity planEntity);
}
