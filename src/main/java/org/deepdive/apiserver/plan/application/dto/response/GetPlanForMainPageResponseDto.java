package org.deepdive.apiserver.plan.application.dto.response;

import java.sql.Timestamp;
import org.deepdive.apiserver.plan.domain.Plan;

public record GetPlanForMainPageResponseDto(
        Long planId,
        String planTitle,
        Timestamp startDate
) {
    public static GetPlanForMainPageResponseDto fromEntity(Plan plan) {
        return new GetPlanForMainPageResponseDto(plan.getPlanId(), plan.getTitle(), plan.getStartDate());
    }
}
