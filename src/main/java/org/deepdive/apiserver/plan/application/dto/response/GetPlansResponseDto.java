package org.deepdive.apiserver.plan.application.dto.response;

import java.util.List;
import org.deepdive.apiserver.plan.domain.Plan;

public record GetPlansResponseDto(List<GetPlanResponseDto> getPlanResponseDtos) {
    public static GetPlansResponseDto fromEntity(List<Plan> plans){
        return new GetPlansResponseDto(plans.stream().map(GetPlanResponseDto::fromEntity).toList());
    }
}
