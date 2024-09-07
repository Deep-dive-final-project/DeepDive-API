package org.deepdive.apiserver.plan.ui;

import org.deepdive.apiserver.plan.application.dto.response.GetPlanResponseDto;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.deepdive.apiserver.plan.application.PlanService;
import org.deepdive.apiserver.security.application.resolver.Login;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/plan")
@RequiredArgsConstructor
public class PlanController {

    private final PlanService planService;

    @GetMapping("/overview")
    public ResponseEntity<List<GetPlanResponseDto>> getPlans(@Login Long userId){
        return ResponseEntity.ok(planService.getPlans(userId));
    }

}
