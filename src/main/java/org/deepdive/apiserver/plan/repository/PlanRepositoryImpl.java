package org.deepdive.apiserver.plan.repository;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.deepdive.apiserver.common.exception.CommonException;
import org.deepdive.apiserver.common.exception.ErrorCode;
import org.deepdive.apiserver.plan.application.interfaces.PlanRepository;
import org.deepdive.apiserver.plan.domain.Plan;
import org.deepdive.apiserver.plan.repository.entity.PlanEntity;
import org.deepdive.apiserver.plan.repository.jpa.JpaPlanRepository;
import org.deepdive.apiserver.security.application.MemberService;
import org.deepdive.apiserver.security.domain.Member;
import org.deepdive.apiserver.security.repository.entity.MemberEntity;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@RequiredArgsConstructor
public class PlanRepositoryImpl implements PlanRepository {

    private final JpaPlanRepository planRepository;
    private final MemberService memberService;

    @Override
    public List<Plan> findAllByMemberId(Long memberId) {
        MemberEntity memberEntity = new MemberEntity(memberService.getMember(memberId));
        List<PlanEntity> planEntities = planRepository.findAllByMember(memberEntity.getMemberId());
        return planEntities.stream().map(PlanEntity::toPlan).toList();
    }

    @Override
    public Plan findById(Long planId) {
        PlanEntity planEntity = planRepository.findById(planId).orElseThrow(() ->
                new CommonException(ErrorCode.NOT_FOUND_PLAN));
        return planEntity.toPlan();
    }

    @Override
    @Transactional
    public void deleteByIdAndMemberId(Long memberId, Long planId) {
        Plan plan = findById(planId);
        Member member = memberService.getMember(memberId);
        if(!plan.getMember().getMemberId().equals(member.getMemberId())) {
            throw new CommonException(ErrorCode.INVALID_ARGUMENT);
        }
        planRepository.delete(new PlanEntity(plan));
    }


}
