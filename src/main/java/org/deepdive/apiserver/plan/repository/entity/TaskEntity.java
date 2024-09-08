package org.deepdive.apiserver.plan.repository.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
import org.deepdive.apiserver.lecture.repository.entity.SectionEntity;
import org.deepdive.apiserver.plan.domain.Task;
import org.deepdive.apiserver.security.repository.entity.MemberEntity;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Getter
@Entity
@Table(name = "task")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class TaskEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "task_id")
    private Long taskId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "plan_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private PlanEntity planEntity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "section_id")
    private SectionEntity sectionEntity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private MemberEntity memberEntity;

    @Column(name = "title")
    private String title;

    @Column(name = "state")
    private String state;

    @Column(name = "complete_date")
    private Timestamp completeDate;


    public TaskEntity(Task task) {
        taskId = task.getTaskId();
        planEntity = new PlanEntity(task.getPlan());
        sectionEntity = new SectionEntity(task.getSection());
        memberEntity = new MemberEntity(task.getMember());
        title = task.getTitle();
        state = task.getState();
        completeDate = task.getCompleteDate();
    }


    public Task toTask(){
        return Task.builder()
                .taskId(taskId)
                .plan(planEntity.toPlan())
                .section(sectionEntity.toSection())
                .member(memberEntity.toMember())
                .title(title)
                .state(state)
                .completeDate(completeDate)
                .build();
    }

    public void updateState(String state){
        this.state = state;
    }
}
