package org.deepdive.apiserver.plan.application.dto.response;

import org.deepdive.apiserver.plan.domain.Plan;

public record GetPlanForPlanPageResponseDto(Long plan_id, String plan_name, String state) {
    public static GetPlanForPlanPageResponseDto fromEntity(Plan plan) {
        return new GetPlanForPlanPageResponseDto(plan.getPlanId(), plan.getTitle(), plan.getState());
    }
}
