package org.deepdive.apiserver.plan.application;

import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.deepdive.apiserver.plan.application.dto.response.GetPlanResponseDto;
import org.deepdive.apiserver.plan.application.interfaces.PlanRepository;
import org.deepdive.apiserver.plan.domain.Plan;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PlanService {

    private final PlanRepository planRepository;

    public List<GetPlanResponseDto>getPlans(Long memberId) {
        List<Plan> plans = planRepository.findAllByMemberId(memberId);
        List<GetPlanResponseDto> responseDtos = new ArrayList<>();
        for(Plan plan : plans) responseDtos.add(GetPlanResponseDto.fromEntity(plan));
        return responseDtos;
    }
}
