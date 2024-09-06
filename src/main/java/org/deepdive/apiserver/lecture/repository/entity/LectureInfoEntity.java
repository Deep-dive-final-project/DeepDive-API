package org.deepdive.apiserver.lecture.repository.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Embeddable;
import java.util.List;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.deepdive.apiserver.lecture.domain.lecture.Lecture;
import org.deepdive.apiserver.lecture.domain.lecture.LectureInfo;

@Getter
@Embeddable
@NoArgsConstructor
public class LectureInfoEntity {

    @Column(name = "title", nullable = false, length = 255)
    private String title;

    @Column(name = "instructor", length = 100)
    private String instructor;

    @Convert(converter = StringToListConverter.class)
    @Column(name = "goals", columnDefinition = "TEXT")
    private List<String> goals;

    @Convert(converter = StringToListConverter.class)
    @Column(name = "target", columnDefinition = "TEXT")
    private List<String> targets;

    public LectureInfoEntity(LectureInfo info) {
        this.title = info.getTitle();
        this.instructor = info.getInstructor();
        this.goals = info.getGoals();
        this.targets = info.getTargets();
    }
}
