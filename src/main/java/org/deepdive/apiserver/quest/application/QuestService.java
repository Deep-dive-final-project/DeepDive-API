package org.deepdive.apiserver.quest.application;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.deepdive.apiserver.quest.application.dto.GetQuestListResponseDto;
import org.deepdive.apiserver.quest.application.interfaces.QuestRepository;
import org.deepdive.apiserver.quest.domain.Quest;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class QuestService {

    private final QuestRepository questRepository;


    public GetQuestListResponseDto findAll() {
        List<Quest> quests = questRepository.findAll();
        return GetQuestListResponseDto.from(quests);
    }
}
