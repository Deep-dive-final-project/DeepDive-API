package org.deepdive.apiserver.plan.ui;

import lombok.RequiredArgsConstructor;
import org.deepdive.apiserver.plan.application.PlanService;
import org.deepdive.apiserver.plan.application.dto.response.GetPlansResponseDto;
import org.deepdive.apiserver.plan.domain.Plan;
import org.deepdive.apiserver.security.application.resolver.Login;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/plan")
@RequiredArgsConstructor
public class PlanController {

    private final PlanService planService;

    @GetMapping("/overview")
    public ResponseEntity<GetPlansResponseDto> getPlans(@Login Long userId){
        return ResponseEntity.ok(planService.getPlans(userId));
    }

    @GetMapping("/{planId}")
    public ResponseEntity<Plan> getPlanDetails(@Login Long userId,
                                               @PathVariable(name = "planId") Long planId){
        return ResponseEntity.ok(planService.getPlan(userId, planId));
    }
}
