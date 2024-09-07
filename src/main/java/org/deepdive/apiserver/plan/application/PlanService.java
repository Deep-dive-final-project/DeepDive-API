package org.deepdive.apiserver.plan.application;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.deepdive.apiserver.plan.application.dto.response.GetPlansResponseDto;
import org.deepdive.apiserver.plan.application.interfaces.PlanRepository;
import org.deepdive.apiserver.plan.domain.Plan;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PlanService {

    private final PlanRepository planRepository;

    public GetPlansResponseDto getPlans(Long memberId) {
        List<Plan> plans = planRepository.findAllByMemberId(memberId);
        return GetPlansResponseDto.fromEntity(plans);
    }

    public Plan getPlan(Long memberId, Long planId) {
        return planRepository.findByIdAndMemberId(memberId, planId);
    }
}
