package org.deepdive.apiserver.lecture.domain;

import java.math.BigDecimal;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Lecture {

    private Long courseId;
    private String title;
    private String imageUrl;
    private String instructor;
    private int price;
    private BigDecimal rating;
    private String lectureUrl;
    private String goals;
    private String target;
    private String preCourse;
    private String platform;
}
