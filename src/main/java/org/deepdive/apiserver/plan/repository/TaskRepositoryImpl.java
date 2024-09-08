package org.deepdive.apiserver.plan.repository;

import lombok.RequiredArgsConstructor;
import org.deepdive.apiserver.common.exception.CommonException;
import org.deepdive.apiserver.common.exception.ErrorCode;
import org.deepdive.apiserver.plan.application.interfaces.TaskRepository;
import org.deepdive.apiserver.plan.domain.Task;
import org.deepdive.apiserver.plan.repository.entity.TaskEntity;
import org.deepdive.apiserver.plan.repository.jpa.JpaTaskRepository;
import org.deepdive.apiserver.security.domain.Member;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class TaskRepositoryImpl implements TaskRepository {

    private final JpaTaskRepository taskRepository;

    @Override
    public Task findById(Long taskId) {
        TaskEntity entity = taskRepository.findById(taskId).orElseThrow(() -> new CommonException(ErrorCode.NOT_FOUND_TASK));

        return entity.toTask();
    }

    @Override
    public List<Task> findAllByPlan(Long planId) {
        List<TaskEntity> entities = taskRepository.findByPlanId(planId);

        return entities.stream().map(TaskEntity::toTask).toList();
    }
}
