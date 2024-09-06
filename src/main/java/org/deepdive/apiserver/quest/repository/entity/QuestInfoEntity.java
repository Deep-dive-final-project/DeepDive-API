package org.deepdive.apiserver.quest.repository.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Lob;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.deepdive.apiserver.quest.domain.QuestInfo;

@Getter
@Embeddable
@NoArgsConstructor
public class QuestInfoEntity {

    private String name;

    @Lob
    @Column(columnDefinition = "TEXT")
    private String content;

    @Lob
    @Column(columnDefinition = "TEXT")
    private String answer;

    @Lob
    @Column(columnDefinition = "TEXT")
    private String feedback;

    public QuestInfoEntity(String name, String content, String answer, String feedback) {
        this.name = name;
        this.content = content;
        this.answer = answer;
        this.feedback = feedback;
    }
}
