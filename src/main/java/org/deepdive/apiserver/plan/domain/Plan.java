package org.deepdive.apiserver.plan.domain;

import java.sql.Timestamp;
import lombok.Builder;
import lombok.Getter;
import org.deepdive.apiserver.lecture.domain.lecture.Lecture;
import org.deepdive.apiserver.security.domain.Member;

@Getter
@Builder
public class Plan {

    private Long planId;
    private String title;
    private Timestamp startDate;
    private Timestamp endDate;
    private String description;
    private String state;
    private Member member;
    private Lecture lecture;
}
