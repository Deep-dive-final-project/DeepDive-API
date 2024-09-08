package org.deepdive.apiserver.plan.application.interfaces;


import org.deepdive.apiserver.plan.domain.Task;

public interface TaskRepository {

    Task findById(Long taskId);
}
