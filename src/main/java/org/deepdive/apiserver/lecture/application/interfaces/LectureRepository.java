package org.deepdive.apiserver.lecture.application.interfaces;

import java.util.List;
import org.deepdive.apiserver.lecture.domain.lecture.Lecture;
import org.deepdive.apiserver.security.domain.Member;

public interface LectureRepository {

    List<Lecture> findAllByMemberId(Member member);

    Lecture findById(Long id);

    Lecture save(Lecture lecture);
}
