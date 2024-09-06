package org.deepdive.apiserver.quest.repository;

import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.deepdive.apiserver.common.exception.CommonException;
import org.deepdive.apiserver.common.exception.ErrorCode;
import org.deepdive.apiserver.quest.application.interfaces.QuestRepository;
import org.deepdive.apiserver.quest.domain.Quest;
import org.deepdive.apiserver.quest.repository.entity.QuestEntity;
import org.deepdive.apiserver.quest.repository.jpa.JpaQuestQueryRepository;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class QuestRepositoryImpl implements QuestRepository {

    private final JpaQuestQueryRepository questQueryRepository;

    public List<Quest> findAll() {
        List<QuestEntity> entities = questQueryRepository.findAll();
        return entities.stream().map(QuestEntity::toQuest).toList();
    }

    @Override
    public Quest findById(Long questId) {
        QuestEntity entity = questQueryRepository.findById(questId)
            .orElseThrow(() -> new CommonException(ErrorCode.NOT_FOUND_QUEST));
        return entity.toQuest();
    }
}
