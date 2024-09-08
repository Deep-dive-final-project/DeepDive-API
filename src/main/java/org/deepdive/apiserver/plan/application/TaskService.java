package org.deepdive.apiserver.plan.application;

import lombok.RequiredArgsConstructor;
import org.deepdive.apiserver.common.exception.CommonException;
import org.deepdive.apiserver.common.exception.ErrorCode;
import org.deepdive.apiserver.plan.application.dto.response.GetTaskListResponseDto;
import org.deepdive.apiserver.plan.application.interfaces.TaskRepository;
import org.deepdive.apiserver.plan.domain.Plan;
import org.deepdive.apiserver.plan.domain.Task;
import org.deepdive.apiserver.security.application.MemberService;
import org.deepdive.apiserver.security.domain.Member;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class TaskService {

    private final TaskRepository taskRepository;
    private final MemberService memberService;
    private final PlanService planService;

    public Task findTask(Long taskId){
        return taskRepository.findById(taskId);
    }

    public List<GetTaskListResponseDto> getTaskList(Long planId, Long memberId){
        Plan plan = planService.getPlan(planId);
        if(!plan.getMember().getMemberId().equals(memberId)){
            throw new CommonException(ErrorCode.ACCESS_DENIED_PLAN);
        }
        List<Task> tasks = taskRepository.findAllByPlan(planId);
        return tasks.stream().map(GetTaskListResponseDto::fromEntity).toList();
    }
}
