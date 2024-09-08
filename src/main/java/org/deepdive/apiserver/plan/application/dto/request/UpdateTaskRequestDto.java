package org.deepdive.apiserver.plan.application.dto.request;

public record UpdateTaskRequestDto(Long taskId, String state) {
}
