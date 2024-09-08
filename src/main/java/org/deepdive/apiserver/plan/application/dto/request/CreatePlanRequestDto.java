package org.deepdive.apiserver.plan.application.dto.request;

import java.sql.Timestamp;

public record CreatePlanRequestDto(String title,
                                   Timestamp start_date,
                                   Timestamp end_date,
                                   String description,
                                   Long lecture_id) {
}
