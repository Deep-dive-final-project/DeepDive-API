package org.deepdive.apiserver.plan.application.dto.request;

import java.sql.Timestamp;

public record CreatePlanRequestDto(String title,
                                   Timestamp start_date,
                                   Timestamp end_date,
                                   String description,
                                             "tasks": [
{
        "task_name": "섹션1. 강의 소개 및 실습 환경 세팅"
},
        {
        "task_name": "섹션2. 논문 이해 - Neural Style Transfer - Intro"
        }
        ]) {
}
