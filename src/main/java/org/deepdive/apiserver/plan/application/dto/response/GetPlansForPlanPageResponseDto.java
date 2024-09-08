package org.deepdive.apiserver.plan.application.dto.response;

import java.util.List;
import org.deepdive.apiserver.plan.domain.Plan;

public record GetPlansForPlanPageResponseDto(List<GetPlanForPlanPageResponseDto> getPlanForPlanPageResponseDtoList) {
    public static GetPlansForPlanPageResponseDto fromEntity(List<Plan> plans){
        return new GetPlansForPlanPageResponseDto(plans.stream().map(GetPlanForPlanPageResponseDto::fromEntity).toList());
    }
}
