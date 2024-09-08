package org.deepdive.apiserver.plan.application.dto.response;

import lombok.Builder;
import org.deepdive.apiserver.plan.domain.Task;

import java.sql.Timestamp;

@Builder
public record GetTaskListResponseDto(
        Long taskId,
        String title,
        String state,
        Timestamp completeDate
) {
    public static GetTaskListResponseDto fromEntity(Task task){
        return GetTaskListResponseDto.builder()
                .taskId(task.getTaskId())
                .title(task.getTitle())
                .state(task.getState())
                .completeDate(task.getCompleteDate())
                .build();
    }
}
