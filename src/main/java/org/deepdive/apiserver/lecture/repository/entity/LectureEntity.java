package org.deepdive.apiserver.lecture.repository.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.math.BigDecimal;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.deepdive.apiserver.lecture.domain.lecture.Lecture;
import org.deepdive.apiserver.lecture.domain.lecture.LectureInfo;
import org.deepdive.apiserver.lecture.domain.lecture.Rating;
import org.deepdive.apiserver.lecture.domain.lecture.Url;
import org.deepdive.apiserver.lecture.domain.lecture.stringlist.Goals;
import org.deepdive.apiserver.lecture.domain.lecture.stringlist.Targets;

@Getter
@Entity
@Table(name = "lecture")
@NoArgsConstructor
public class LectureEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "lecture_id")
    private Long lectureId;

    @Embedded
    private LectureInfoEntity info;

    @Column(name = "rating", precision = 2, scale = 1)
    private BigDecimal rating;

    @Column(name = "image_url", length = 255)
    private String imageUrl;

    @Column(name = "lecture_url", length = 255)
    private String lectureUrl;

    public LectureEntity(Lecture lecture) {
        this.lectureId = lecture.getLectureId();
        this.info = new LectureInfoEntity(lecture.getInfo());
        this.rating = lecture.getRating();
        this.imageUrl = lecture.getImageUrl();
        this.lectureUrl = lecture.getLectureUrl();
    }

    public Lecture toLecture() {
        return Lecture.builder()
            .lectureId(lectureId)
            .info(new LectureInfo(info.getTitle(), info.getInstructor(), new Goals(info.getGoals()),
                new Targets(info.getTargets())))
            .imageUrl(new Url(imageUrl))
            .lectureUrl(new Url(lectureUrl))
            .rating(new Rating(rating))
            .build();
    }
}
