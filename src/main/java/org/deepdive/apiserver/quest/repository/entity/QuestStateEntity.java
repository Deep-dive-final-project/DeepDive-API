package org.deepdive.apiserver.quest.repository.entity;

import lombok.Getter;

@Getter
public enum QuestStateEntity {
    UNSOLVED("unsolved"),
    SOLVED("solved");

    private final String state;

    QuestStateEntity(String state) {
        this.state = state;
    }

    public static QuestStateEntity from(String state) {
        for (QuestStateEntity questState : QuestStateEntity.values()) {
            if (questState.getState().equalsIgnoreCase(state)) {
                return questState;
            }
        }
        throw new IllegalArgumentException();
    }
}

