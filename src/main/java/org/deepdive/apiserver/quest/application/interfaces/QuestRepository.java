package org.deepdive.apiserver.quest.application.interfaces;

import java.util.List;
import org.deepdive.apiserver.quest.application.dto.GetQuestDetailResponseDto;
import org.deepdive.apiserver.quest.domain.Quest;
import org.deepdive.apiserver.security.domain.Member;

public interface QuestRepository {

    List<Quest> findAll(Member member);

    Quest findById(Member member, Long questId);
}
