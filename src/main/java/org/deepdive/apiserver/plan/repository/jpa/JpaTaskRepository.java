package org.deepdive.apiserver.plan.repository.jpa;

import org.deepdive.apiserver.plan.repository.entity.TaskEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaTaskRepository extends JpaRepository<TaskEntity, Long> {
}
