package org.deepdive.apiserver.plan.domain;

import java.sql.Timestamp;
import lombok.Builder;
import lombok.Getter;
import org.deepdive.apiserver.lecture.domain.section.Section;
import org.deepdive.apiserver.security.domain.Member;

@Builder
@Getter
public class Task {

    private Long taskId;
    private Plan plan;
    private Section section;
    private Member member;
    private String title;
    private String state;
    private Timestamp completeDate;

    public static Task createTask(Plan plan, Section section, Member member, String title) {
        return Task.builder()
                .plan(plan)
                .section(section)
                .member(member)
                .title(title)
                .state("PENDING")
                .build();
    }
}