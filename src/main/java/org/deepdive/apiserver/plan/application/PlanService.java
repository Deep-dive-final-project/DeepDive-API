package org.deepdive.apiserver.plan.application;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.deepdive.apiserver.common.dto.CommonSuccessDto;
import org.deepdive.apiserver.plan.application.dto.response.GetPlansResponseDto;
import org.deepdive.apiserver.plan.application.interfaces.PlanRepository;
import org.deepdive.apiserver.plan.domain.Plan;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class PlanService {

    private final PlanRepository planRepository;

    public GetPlansResponseDto getPlans(Long memberId) {
        List<Plan> plans = planRepository.findAllByMemberId(memberId);
        return GetPlansResponseDto.fromEntity(plans);
    }

    public CommonSuccessDto deletePlan(Long memberId, Long planId) {
        planRepository.deleteByIdAndMemberId(memberId,planId);
        return CommonSuccessDto.fromEntity(true);
    }
}
