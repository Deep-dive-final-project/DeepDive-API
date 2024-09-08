package org.deepdive.apiserver.quest.domain;

import java.sql.Timestamp;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import org.deepdive.apiserver.security.domain.Member;

@Builder
@AllArgsConstructor
public class Quest {

    @Getter
    private Long questId;
    private QuestInfo questInfo;
    private QuestState state;

    @Getter
    private Timestamp createdDate;
    @Getter
    private Member member;

    public String getName() {
        return questInfo.getName();
    }

    public String getContent() {
        return questInfo.getContent();
    }

    public String getAnswer() {
        return questInfo.getAnswer();
    }

    public String getFeedback() {
        return questInfo.getFeedback();
    }

    public String getState() {
        return state.getState();
    }
}
