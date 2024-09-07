package org.deepdive.apiserver.plan.repository.jpa;

import org.deepdive.apiserver.plan.repository.entity.TaskEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface JpaTaskRepository extends JpaRepository<TaskEntity, Long> {

    @Query( "select t from TaskEntity t" +
            " join fetch t.planEntity p" +
            " where t.planEntity.planId = :planId")
    List<TaskEntity> findByPlanId(@Param("planId") Long planId);
}
