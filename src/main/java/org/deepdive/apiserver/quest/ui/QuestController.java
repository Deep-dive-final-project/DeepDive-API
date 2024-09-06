package org.deepdive.apiserver.quest.ui;

import lombok.RequiredArgsConstructor;
import org.deepdive.apiserver.common.dto.ResponseDto;
import org.deepdive.apiserver.quest.application.QuestService;
import org.deepdive.apiserver.quest.application.dto.GetQuestListResponseDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/quest")
@RequiredArgsConstructor
public class QuestController {

    private final QuestService questService;

    @GetMapping("")
    public ResponseDto<GetQuestListResponseDto> getQuests() {
        return ResponseDto.ok(questService.findAll());
    }
}
