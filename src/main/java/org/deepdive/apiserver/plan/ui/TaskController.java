package org.deepdive.apiserver.plan.ui;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.deepdive.apiserver.common.dto.CommonSuccessDto;
import org.deepdive.apiserver.plan.application.TaskService;
import org.deepdive.apiserver.plan.application.dto.request.UpdateTaskRequestDto;
import org.deepdive.apiserver.plan.application.dto.response.GetTaskListResponseDto;
import org.deepdive.apiserver.security.application.resolver.Login;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/task")
@RequiredArgsConstructor
public class TaskController {

    private final TaskService taskService;

    @GetMapping("/{plan_id}")
    public ResponseEntity<List<GetTaskListResponseDto>> getTaskList(@Login Long memberId, @PathVariable("plan_id") Long plan_id){
        return ResponseEntity.ok(taskService.getTaskList(plan_id, memberId));
    }

    @PatchMapping("/change")
    public CommonSuccessDto updateTaskState(@Login Long memberId, @RequestBody UpdateTaskRequestDto updateTaskRequestDto){
        taskService.updateTaskState(memberId, updateTaskRequestDto);
        return CommonSuccessDto.fromEntity(true);
    }
}
