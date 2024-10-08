package org.deepdive.apiserver.lecture.repository.jpa;

import java.util.List;
import org.deepdive.apiserver.lecture.repository.entity.MyLectureEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface JpaMyLectureQueryRepository extends JpaRepository<MyLectureEntity, Long> {

    @Query("select ml from MyLectureEntity ml"
        + " join fetch ml.member m"
        + " where m.memberId=:memberId")
    List<MyLectureEntity> findAllByMemberId(@Param("memberId") Long memberId);
}
