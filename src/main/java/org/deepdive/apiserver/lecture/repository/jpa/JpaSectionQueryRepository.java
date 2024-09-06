package org.deepdive.apiserver.lecture.repository.jpa;

import java.util.List;
import org.deepdive.apiserver.lecture.repository.entity.SectionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface JpaSectionQueryRepository extends JpaRepository<SectionEntity, Long> {

    @Query("select s from SectionEntity  s"
        + " join fetch s.lecture l"
        + " where l.lectureId=:lectureId")
    List<SectionEntity> findAllByLectureId(@Param("lectureId") Long lectureId);
}
