package org.deepdive.apiserver.plan.application;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.deepdive.apiserver.common.dto.CommonSuccessDto;
import org.deepdive.apiserver.plan.application.dto.response.GetPlansForMainPageResponseDto;
import org.deepdive.apiserver.plan.application.dto.response.GetPlansForPlanPageResponseDto;
import org.deepdive.apiserver.plan.application.interfaces.PlanRepository;
import org.deepdive.apiserver.plan.domain.Plan;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PlanService {

    private final PlanRepository planRepository;

    public GetPlansForMainPageResponseDto getPlansForMainPageResponse(Long memberId) {
        List<Plan> plans = planRepository.findAllByMemberId(memberId);
        return GetPlansForMainPageResponseDto.fromEntity(plans);
    }

    public GetPlansForPlanPageResponseDto getPlansForPlanPageResponse(Long memberId) {
        List<Plan> plans = planRepository.findAllByMemberId(memberId);
        return GetPlansForPlanPageResponseDto.fromEntity(plans);
    }

    public Plan getPlan(Long memberId, Long planId) {
        return planRepository.findByIdAndMemberId(memberId, planId);
    }

    public CommonSuccessDto deletePlan(Long memberId, Long planId) {
        planRepository.deleteByIdAndMemberId(memberId,planId);
        return CommonSuccessDto.fromEntity(true);
    }
}
