package org.deepdive.apiserver.plan.application.dto.response;

import java.sql.Timestamp;
import org.deepdive.apiserver.plan.domain.Plan;

public record GetPlanDetailResponseDto(Long planId,
                                       String planName,
                                       Timestamp startDate,
                                       Timestamp endDate,
                                       String description,
                                       String state) {
    public static GetPlanDetailResponseDto fromEntity(Plan plan) {
        return new GetPlanDetailResponseDto(
                plan.getPlanId(),
                plan.getTitle(),
                plan.getStartDate(),
                plan.getEndDate(),
                plan.getDescription(),
                plan.getState()
        );
    }
}
