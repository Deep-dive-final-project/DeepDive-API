package org.deepdive.apiserver.quest.repository;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.deepdive.apiserver.common.exception.CommonException;
import org.deepdive.apiserver.common.exception.ErrorCode;
import org.deepdive.apiserver.quest.application.interfaces.QuestRepository;
import org.deepdive.apiserver.quest.domain.Quest;
import org.deepdive.apiserver.quest.repository.entity.QuestEntity;
import org.deepdive.apiserver.quest.repository.entity.QuestStateEntity;
import org.deepdive.apiserver.quest.repository.jpa.JpaQuestQueryRepository;
import org.deepdive.apiserver.security.domain.Member;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class QuestRepositoryImpl implements QuestRepository {

    private final JpaQuestQueryRepository questQueryRepository;

    public List<Quest> findAll(Member member) {
        List<QuestEntity> entities = questQueryRepository.findAllByMemberId(member.getMemberId(), QuestStateEntity.UNSOLVED);
        return entities.stream().map(QuestEntity::toQuest).toList();
    }

    @Override
    public Quest findById(Member member, Long questId) {
        QuestEntity entity = questQueryRepository.findByMemberId(member.getMemberId(), questId)
            .orElseThrow(() -> new CommonException(ErrorCode.NOT_FOUND_QUEST));
        return entity.toQuest();
    }
}
