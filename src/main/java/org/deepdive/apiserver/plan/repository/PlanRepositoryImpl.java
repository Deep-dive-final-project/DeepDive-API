package org.deepdive.apiserver.plan.repository;

import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.deepdive.apiserver.member.domain.Member;
import org.deepdive.apiserver.plan.application.interfaces.PlanRepository;
import org.deepdive.apiserver.plan.domain.Plan;
import org.deepdive.apiserver.plan.repository.entity.PlanEntity;
import org.deepdive.apiserver.plan.repository.jpa.JpaPlanRepository;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class PlanRepositoryImpl implements PlanRepository {

    private final JpaPlanRepository planRepository;

    @Override
    public List<Plan> findAllByMemberId(Member member) {
        List<PlanEntity> entities = planRepository.findAllByMember(member);
        List<Plan> plans = new ArrayList<>();
        for (PlanEntity entity : entities) {
            plans.add(entity.toPlan());
        }
        return plans;
    }
}
