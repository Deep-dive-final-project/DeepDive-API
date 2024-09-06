package org.deepdive.apiserver.quest.repository.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDate;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.deepdive.apiserver.common.repository.entity.BaseTimeEntity;
import org.deepdive.apiserver.quest.domain.Quest;
import org.deepdive.apiserver.quest.domain.QuestInfo;
import org.deepdive.apiserver.quest.domain.QuestState;

@Getter
@Entity
@Table(name = "quest")
@NoArgsConstructor
public class QuestEntity extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "quest_id")
    private Long questId;

    @Embedded
    private QuestInfoEntity info;

    @Enumerated(EnumType.STRING)
    private QuestStateEntity state;

    public QuestEntity(Quest quest) {
        this.questId = quest.getQuestId();
        this.info = new QuestInfoEntity(quest.getName(), quest.getContent(), quest.getAnswer(),
            quest.getFeedback());
        this.state = QuestStateEntity.from(quest.getState());
    }

    public Quest toQuest() {
        return Quest.builder()
            .questId(questId)
            .questInfo(new QuestInfo(info.getName(), info.getContent(), info.getAnswer(),
                info.getFeedback()))
            .state(new QuestState(state.getState()))
            .createdDate(LocalDate.from(getCreatedDate()))
            .build();
    }
}
