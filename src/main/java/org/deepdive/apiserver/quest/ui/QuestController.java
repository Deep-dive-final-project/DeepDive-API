package org.deepdive.apiserver.quest.ui;

import lombok.RequiredArgsConstructor;
import org.deepdive.apiserver.common.dto.ResponseDto;
import org.deepdive.apiserver.quest.application.QuestService;
import org.deepdive.apiserver.quest.application.dto.GetQuestDetailResponseDto;
import org.deepdive.apiserver.quest.application.dto.GetQuestListResponseDto;
import org.deepdive.apiserver.security.application.resolver.Login;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/quest")
@RequiredArgsConstructor
public class QuestController {

    private final QuestService questService;

    @GetMapping("")
    public ResponseDto<GetQuestListResponseDto> getQuests(@Login Long memberId) {
        return ResponseDto.ok(questService.findAll(memberId));
    }

    @GetMapping("/{questId}")
    public ResponseDto<GetQuestDetailResponseDto> getQuest(@Login Long memberId, @PathVariable("questId") Long questId) {
        return ResponseDto.ok(questService.findQuestByMemberId(memberId, questId));
    }
}
