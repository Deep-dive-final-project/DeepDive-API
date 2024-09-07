package org.deepdive.apiserver.plan.application.interfaces;

import java.util.List;
import org.deepdive.apiserver.plan.domain.Plan;

public interface PlanRepository {

    List<Plan> findAllByMemberId(Long memeberId);

    Plan findByIdAndMemberId(Long memberId, Long planId);

    void deleteByIdAndMemberId(Long member, Long plan);
}
