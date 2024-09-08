package org.deepdive.apiserver.plan.application.interfaces;


import org.deepdive.apiserver.plan.domain.Task;
import org.deepdive.apiserver.security.domain.Member;

import java.util.List;

public interface TaskRepository {

    Task findById(Long taskId);

    List<Task> findAllByPlan(Long planId);
}
