package org.deepdive.apiserver.plan.application.dto.response;

import java.sql.Timestamp;
import org.deepdive.apiserver.plan.domain.Plan;

public record GetPlanResponseDto(
        Long planId,
        String planTitle,
        Timestamp startDate
) {
    public static GetPlanResponseDto fromEntity(Plan plan) {
        return new GetPlanResponseDto(plan.getPlanId(), plan.getTitle(), plan.getStartDate());
    }
}
