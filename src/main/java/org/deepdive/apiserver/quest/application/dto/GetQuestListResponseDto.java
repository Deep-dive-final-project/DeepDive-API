package org.deepdive.apiserver.quest.application.dto;

import java.util.List;
import org.deepdive.apiserver.lecture.application.dto.response.GetLectureListResponseDto;
import org.deepdive.apiserver.quest.domain.Quest;

public record GetQuestListResponseDto(List<GetQuestResponseDto> dtos) {

    public static GetQuestListResponseDto from(List<Quest> quests) {
        List<GetQuestResponseDto> dtos = quests.stream()
            .map(quest -> new GetQuestResponseDto(quest.getQuestId(), quest.getName(),
                quest.getContent(), quest.getAnswer(), quest.getFeedback(), quest.getCreatedDate()))
            .toList();
        return new GetQuestListResponseDto(dtos);
    }
}
