package org.deepdive.apiserver.plan.repository.jpa;

import io.lettuce.core.dynamic.annotation.Param;
import java.util.List;
import org.deepdive.apiserver.plan.repository.entity.PlanEntity;
import org.deepdive.apiserver.security.repository.entity.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface JpaPlanRepository extends JpaRepository<PlanEntity, Long> {

    @Query("select p from PlanEntity p"+
            " where p.memberEntity in :memberEntity")
    List<PlanEntity> findAllByMember(@Param("memberEntity")MemberEntity memberEntity);
}
