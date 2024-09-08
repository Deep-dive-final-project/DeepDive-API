package org.deepdive.apiserver.plan.repository.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.sql.Timestamp;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.deepdive.apiserver.lecture.repository.entity.LectureEntity;
import org.deepdive.apiserver.plan.domain.Plan;
import org.deepdive.apiserver.security.repository.entity.MemberEntity;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Getter
@Entity
@Table(name = "plan")
@EntityListeners(AuditingEntityListener.class)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class PlanEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "plan_id")
    private Long planId;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "start_date", nullable = false)
    private Timestamp startDate;

    @Column(name = "end_date", nullable = false)
    private Timestamp endDate;

    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    @Column(name = "state")
    private String state;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "lecture_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private LectureEntity lectureEntity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private MemberEntity memberEntity;

    @LastModifiedDate
    private Timestamp modifiedDate;

    public PlanEntity(Plan plan) {
        planId = plan.getPlanId();
        title = plan.getTitle();
        startDate = plan.getStartDate();
        endDate = plan.getEndDate();
        description = plan.getDescription();
        state = plan.getState();
        memberEntity = new MemberEntity(plan.getMember());
        lectureEntity = new LectureEntity(plan.getLecture());
    }

    public Plan toPlan(){
        return Plan.builder()
                .planId(planId)
                .title(title)
                .startDate(startDate)
                .endDate(endDate)
                .description(description)
                .state(state)
                .member(memberEntity.toMember())
                .lecture(lectureEntity.toLecture())
                .build();
    }
}
