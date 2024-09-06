package org.deepdive.apiserver.lecture.application.interfaces;

import java.util.List;
import org.deepdive.apiserver.lecture.domain.lecture.Lecture;

public interface LectureRepository {

    List<Lecture> findAllByMemberId(Long memberId);

    Lecture findById(Long id);

    Lecture save(Lecture lecture);
}
