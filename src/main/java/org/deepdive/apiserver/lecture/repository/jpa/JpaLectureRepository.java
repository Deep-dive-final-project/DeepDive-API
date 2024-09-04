package org.deepdive.apiserver.lecture.repository.jpa;

import org.deepdive.apiserver.lecture.repository.entity.LectureEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaLectureRepository extends JpaRepository<LectureEntity, Long> {

}
