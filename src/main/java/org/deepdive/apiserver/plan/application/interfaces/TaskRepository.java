package org.deepdive.apiserver.plan.application.interfaces;


import java.util.List;
import org.deepdive.apiserver.plan.domain.Task;

public interface TaskRepository {

    Task findById(Long taskId);

    void saveAll(List<Task> taskList);

    List<Task> findAllByPlan(Long planId);
}
