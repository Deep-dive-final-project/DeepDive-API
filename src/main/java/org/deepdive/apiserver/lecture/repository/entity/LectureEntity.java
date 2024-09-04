package org.deepdive.apiserver.lecture.repository.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.math.BigDecimal;
import lombok.Getter;
import org.deepdive.apiserver.lecture.domain.Lecture;

@Getter
@Entity
@Table(name = "course")
public class LectureEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "course_id")
    private Long courseId;

    @Column(name = "title", nullable = false, length = 255)
    private String title;

    @Column(name = "image_url", length = 255)
    private String imageUrl;

    @Column(name = "instructor", length = 100)
    private String instructor;

    private int price;

    @Column(name = "rating", precision = 2, scale = 1)
    private BigDecimal rating;

    @Column(name = "lecture_url", length = 255)
    private String lectureUrl;

    @Column(name = "goals", columnDefinition = "TEXT")
    private String goals;

    @Column(name = "target", columnDefinition = "TEXT")
    private String target;

    @Column(name = "pre_course", columnDefinition = "TEXT")
    private String preCourse;

    @Column(name = "platform", nullable = false, length = 50)
    private String platform;

    public LectureEntity(Lecture lecture) {
        // 생성자 채우기
    }

    public Lecture toLecture() {
        return Lecture.builder()
            .build();
    }
}
