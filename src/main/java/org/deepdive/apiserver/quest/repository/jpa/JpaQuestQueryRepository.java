package org.deepdive.apiserver.quest.repository.jpa;

import org.deepdive.apiserver.quest.repository.entity.QuestEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaQuestQueryRepository extends JpaRepository<QuestEntity, Long> {

}
