package org.deepdive.apiserver.lecture.application.dto.response;

import java.math.BigDecimal;
import org.deepdive.apiserver.lecture.domain.Lecture;

public record GetLectureResponseDto(
    Long id,
    String title,
    String image_url,
    String instructor,
    int price,
    BigDecimal rating,
    String lecture_url,
    String goals,
    String target,
    String platform
) {

    public static GetLectureResponseDto fromEntity(Lecture course) {
//        return new LectureResponseDto(course.getCourseId(), course.getTitle(), course.getImageUrl(),
//            course.getInstructor(), course.getPrice(), course.getRating(), course.getLectureUrl(),
//            course.getGoals(), course.getTarget(),
//            course.getPlatform());
    }
}
