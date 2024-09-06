package org.deepdive.apiserver.quest.application.interfaces;

import java.util.List;
import org.deepdive.apiserver.quest.application.dto.GetQuestDetailResponseDto;
import org.deepdive.apiserver.quest.domain.Quest;

public interface QuestRepository {

    List<Quest> findAll();

    Quest findById(Long questId);
}
