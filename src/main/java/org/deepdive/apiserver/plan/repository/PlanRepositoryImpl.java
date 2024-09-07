package org.deepdive.apiserver.plan.repository;

import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.deepdive.apiserver.plan.application.interfaces.PlanRepository;
import org.deepdive.apiserver.plan.domain.Plan;
import org.deepdive.apiserver.plan.repository.entity.PlanEntity;
import org.deepdive.apiserver.plan.repository.jpa.JpaPlanRepository;
import org.deepdive.apiserver.security.application.interfaces.MemberRepository;
import org.deepdive.apiserver.security.domain.Member;
import org.deepdive.apiserver.security.repository.entity.MemberEntity;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class PlanRepositoryImpl implements PlanRepository {

    private final JpaPlanRepository planRepository;
    private final MemberRepository memberRepository;

    @Override
    public List<Plan> findAllByMemberId(Long memberId) {
        MemberEntity memberEntity = new MemberEntity(memberRepository.findById(memberId));
        List<PlanEntity> entities = planRepository.findAllByMember(memberEntity);
        List<Plan> plans = new ArrayList<>();
        for (PlanEntity entity : entities) plans.add(entity.toPlan());
        return plans;
    }
}
