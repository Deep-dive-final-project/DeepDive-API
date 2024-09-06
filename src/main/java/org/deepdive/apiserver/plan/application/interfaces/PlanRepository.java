package org.deepdive.apiserver.plan.application.interfaces;

import java.util.List;
import org.deepdive.apiserver.member.domain.Member;
import org.deepdive.apiserver.plan.domain.Plan;

public interface PlanRepository {

    List<Plan> findAllByMemberId(Member member);
}
