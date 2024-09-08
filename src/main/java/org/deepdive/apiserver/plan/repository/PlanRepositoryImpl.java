package org.deepdive.apiserver.plan.repository;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.deepdive.apiserver.common.exception.CommonException;
import org.deepdive.apiserver.common.exception.ErrorCode;
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
    public List<Plan> findAllByMemberId(Long memberId) {
        List<PlanEntity> planEntities = planRepository.findAllByMember(memberId);
        return planEntities.stream().map(PlanEntity::toPlan).toList();
    }


    @Override
    public Plan findByIdAndMemberId(Long memberId, Long planId) {
        return planRepository.findByIdAndMemberId(memberId, planId).toPlan();
    }

    @Override
    public void deleteByIdAndMemberId(Long memberId, Long planId) {
        Plan plan = findByIdAndMemberId(memberId,planId);
        if(!plan.getMember().getMemberId().equals(memberId)) {
            throw new CommonException(ErrorCode.INVALID_ARGUMENT);
        }
        planRepository.delete(new PlanEntity(plan));
    }

    @Override
    public Plan save(Plan plan) {
        PlanEntity planEntity = new PlanEntity(plan);
        planRepository.save(planEntity);
        return planEntity.toPlan();
    }
    @Override
    public Plan findById(Long planId) {
        PlanEntity entity = planRepository.findById(planId).orElseThrow(() -> new CommonException(ErrorCode.NOT_FOUND_PLAN));
        return entity.toPlan();
    }


}
