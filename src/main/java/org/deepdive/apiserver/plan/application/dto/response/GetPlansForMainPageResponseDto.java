package org.deepdive.apiserver.plan.application.dto.response;

import java.util.List;
import org.deepdive.apiserver.plan.domain.Plan;

public record GetPlansForMainPageResponseDto(List<GetPlanForMainPageResponseDto> getPlanForMainPageResponseDtos) {
    public static GetPlansForMainPageResponseDto fromEntity(List<Plan> plans){
        return new GetPlansForMainPageResponseDto(plans.stream().map(GetPlanForMainPageResponseDto::fromEntity).toList());
    }
}
