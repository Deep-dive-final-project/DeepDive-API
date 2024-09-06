package org.deepdive.apiserver.quest.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class QuestInfo {
    private String name;
    private String content;
    private String answer;
    private String feedback;
}
