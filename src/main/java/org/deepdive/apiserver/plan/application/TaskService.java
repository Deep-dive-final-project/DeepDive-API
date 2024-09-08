package org.deepdive.apiserver.plan.application;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.deepdive.apiserver.common.exception.CommonException;
import org.deepdive.apiserver.common.exception.ErrorCode;
import org.deepdive.apiserver.plan.application.dto.response.GetTaskListResponseDto;
import org.deepdive.apiserver.plan.application.interfaces.TaskRepository;
import org.deepdive.apiserver.plan.domain.Task;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class TaskService {

    private final TaskRepository taskRepository;

    public Task findTask(Long taskId){
        return taskRepository.findById(taskId);
    }

    @Transactional
    public void saveAll(List<Task> taskList) {
        taskRepository.saveAll(taskList);
    }

    public List<GetTaskListResponseDto> getTaskList(Long planId, Long memberId){
        List<Task> tasks = taskRepository.findAllByPlan(planId);
        for(Task task : tasks){
            if(!task.getMember().getMemberId().equals(memberId)){
                throw new CommonException(ErrorCode.ACCESS_DENIED_PLAN);            }
        }
        return tasks.stream().map(GetTaskListResponseDto::fromEntity).toList();
    }
}
