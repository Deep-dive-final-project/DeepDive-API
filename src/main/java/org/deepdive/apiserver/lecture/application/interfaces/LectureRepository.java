package org.deepdive.apiserver.lecture.application.interfaces;

import org.deepdive.apiserver.lecture.domain.Lecture;

public interface LectureRepository {

    Lecture findById(Long id);

    Lecture save(Lecture lecture);
}
