package org.deepdive.apiserver.quest.domain;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Builder
@AllArgsConstructor
public class Quest {

    @Getter
    private Long questId;
    private QuestInfo questInfo;
    private QuestState state;

    @Getter
    private LocalDate createdDate;

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
