package org.deepdive.apiserver.plan.ui;

import lombok.RequiredArgsConstructor;
import org.deepdive.apiserver.plan.application.TaskService;
import org.deepdive.apiserver.plan.application.dto.response.GetTaskListResponseDto;
import org.deepdive.apiserver.security.application.resolver.Login;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/task")
@RequiredArgsConstructor
public class TaskController {

    private final TaskService taskService;

    @GetMapping("/{plan_id}")
    public ResponseEntity<List<GetTaskListResponseDto>> getTaskList(@Login Long memberId, @PathVariable("plan_id") Long plan_id){
        return ResponseEntity.ok(taskService.getTaskList(plan_id));
    }
}
