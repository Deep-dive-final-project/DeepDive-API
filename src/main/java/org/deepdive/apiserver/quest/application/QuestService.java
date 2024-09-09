package org.deepdive.apiserver.quest.application;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.deepdive.apiserver.quest.application.dto.GetQuestDetailResponseDto;
import org.deepdive.apiserver.quest.application.dto.GetQuestListResponseDto;
import org.deepdive.apiserver.quest.application.interfaces.QuestRepository;
import org.deepdive.apiserver.quest.domain.Quest;
import org.deepdive.apiserver.security.application.service.MemberService;
import org.deepdive.apiserver.security.domain.Member;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class QuestService {

    private final QuestRepository questRepository;
    private final MemberService memberService;

    public GetQuestListResponseDto findAll(Long memberId) {
        Member member = memberService.getMember(memberId);
        List<Quest> quests = questRepository.findAll(member);
        return GetQuestListResponseDto.from(quests);
    }

    public GetQuestDetailResponseDto findQuestByMemberId(Long memberId, Long questId) {
        Member member = memberService.getMember(memberId);
        Quest quest = questRepository.findById(member, questId);
        return new GetQuestDetailResponseDto(quest.getName(), quest.getContent(), quest.getAnswer(),
            quest.getFeedback(), quest.getCreatedDate());
    }
}
