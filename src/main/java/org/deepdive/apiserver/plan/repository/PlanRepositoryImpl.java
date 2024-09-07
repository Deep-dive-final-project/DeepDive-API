package org.deepdive.apiserver.plan.repository;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.deepdive.apiserver.plan.application.interfaces.PlanRepository;
import org.deepdive.apiserver.plan.domain.Plan;
import org.deepdive.apiserver.plan.repository.entity.PlanEntity;
import org.deepdive.apiserver.plan.repository.jpa.JpaPlanRepository;
import org.deepdive.apiserver.security.application.MemberService;
import org.deepdive.apiserver.security.repository.entity.MemberEntity;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class PlanRepositoryImpl implements PlanRepository {

    private final JpaPlanRepository planRepository;
    private final MemberService memberService;



    @Override
    public List<Plan> findAllByMemberId(Long memberId) {
        MemberEntity memberEntity = new MemberEntity(memberService.getMember(memberId));
        List<PlanEntity> entities = planRepository.findAllByMember(memberEntity.getMemberId());
        return entities.stream().map(PlanEntity::toPlan).toList();
    }

    @Override
    public Plan findByIdAndMemberId(Long memberId, Long planId) {
        MemberEntity memberEntity = new MemberEntity(memberService.getMember(memberId));
        return planRepository.findByIdAndMemberId(memberEntity.getMemberId(), planId);
    }

}
