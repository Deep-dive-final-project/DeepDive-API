package org.deepdive.apiserver.quest.repository.jpa;

import java.util.List;
import java.util.Optional;
import org.deepdive.apiserver.quest.repository.entity.QuestEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface JpaQuestQueryRepository extends JpaRepository<QuestEntity, Long> {

    @Query("select q from QuestEntity q"
        + " join fetch q.member m"
        + " where m.memberId=:memberId")
    List<QuestEntity> findAllByMemberId(@Param("memberId") Long memberId);

    @Query("select q from QuestEntity q"
        + " join fetch q.member m"
        + " where m.memberId=:memberId"
        + " and q.questId=:questId")
    Optional<QuestEntity> findByMemberId(@Param("memberId") Long memberId,
        @Param("questId") Long questId);
}
