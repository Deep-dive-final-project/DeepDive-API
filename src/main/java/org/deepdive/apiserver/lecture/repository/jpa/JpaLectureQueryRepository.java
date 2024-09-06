package org.deepdive.apiserver.lecture.repository.jpa;

import java.util.List;
import org.deepdive.apiserver.lecture.repository.entity.LectureEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface JpaLectureQueryRepository extends JpaRepository<LectureEntity, Long> {

    @Query("select l from LectureEntity l"
        + " where l.lectureId in :ids")
    List<LectureEntity> findAllInMyLectureIds(List<Long> ids);
}
