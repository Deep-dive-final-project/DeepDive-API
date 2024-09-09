package org.deepdive.apiserver.lecture.repository.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import org.deepdive.apiserver.security.repository.entity.MemberEntity;

@Entity
@Getter
public class MyLectureEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long myLectureId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private MemberEntity member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "lecture_id")
    private LectureEntity lecture;

    public Long getLectureId() {
        return lecture.getLectureId();
    }
}
