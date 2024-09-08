package org.deepdive.apiserver.plan.application;

import java.sql.Timestamp;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.deepdive.apiserver.common.dto.CommonSuccessDto;
import org.deepdive.apiserver.lecture.application.LectureService;
import org.deepdive.apiserver.lecture.application.SectionService;
import org.deepdive.apiserver.lecture.domain.lecture.Lecture;
import org.deepdive.apiserver.lecture.domain.section.Section;
import org.deepdive.apiserver.plan.application.dto.request.CreatePlanRequestDto;
import org.deepdive.apiserver.plan.application.dto.response.GetPlanDetailResponseDto;
import org.deepdive.apiserver.plan.application.dto.response.GetPlansForMainPageResponseDto;
import org.deepdive.apiserver.plan.application.dto.response.GetPlansForPlanPageResponseDto;
import org.deepdive.apiserver.plan.application.interfaces.PlanRepository;
import org.deepdive.apiserver.plan.domain.Plan;
import org.deepdive.apiserver.plan.domain.Task;
import org.deepdive.apiserver.security.application.MemberService;
import org.deepdive.apiserver.security.domain.Member;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class PlanService {

    private final PlanRepository planRepository;
    private final MemberService memberService;
    private final LectureService lectureService;
    private final SectionService sectionService;
    private final TaskService taskService;

    public GetPlansForMainPageResponseDto getPlansForMainPageResponse(Long memberId) {
        List<Plan> plans = planRepository.findAllByMemberId(memberId);
        return GetPlansForMainPageResponseDto.fromEntity(plans);
    }

    public GetPlansForPlanPageResponseDto getPlansForPlanPageResponse(Long memberId) {
        List<Plan> plans = planRepository.findAllByMemberId(memberId);
        return GetPlansForPlanPageResponseDto.fromEntity(plans);
    }

    public GetPlanDetailResponseDto getPlanDetail(Long memberId, Long planId) {
        Plan plan = planRepository.findByIdAndMemberId(memberId, planId);
        return GetPlanDetailResponseDto.fromEntity(plan);
    }

    @Transactional
    public CommonSuccessDto deletePlan(Long memberId, Long planId) {
        planRepository.deleteByIdAndMemberId(memberId,planId);
        return CommonSuccessDto.fromEntity(true);
    }

    @Transactional
    public CommonSuccessDto createPlan(Long memberId, CreatePlanRequestDto createPlanRequestDto) {

        // 학습 계획 저장
        Member member = memberService.getMember(memberId);
        Lecture lecture = lectureService.getLecture(createPlanRequestDto.lecture_id());
        String title = createPlanRequestDto.title();
        Timestamp startDate = createPlanRequestDto.start_date();
        Timestamp endDate = createPlanRequestDto.end_date();
        String description = createPlanRequestDto.description();

        Plan plan = planRepository.save(Plan.createPlan(title, startDate, endDate, description, member, lecture));

        //테스크들 저장
        List<Section> sectionList = sectionService.findSectionNames(createPlanRequestDto.lecture_id());
        List<Task> taskList = sectionList.stream()
                .map(section -> Task.createTask(plan, section, member, title))
                .toList();

        taskService.saveAll(taskList);

        return new CommonSuccessDto(true);
    }

    public Plan getPlan(Long planId){
        return planRepository.findById(planId);
    }
}
