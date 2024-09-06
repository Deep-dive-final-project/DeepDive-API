package org.deepdive.apiserver.note.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;
import org.deepdive.apiserver.security.entity.Member;
import org.hibernate.annotations.OnDelete;

import static jakarta.persistence.FetchType.LAZY;
import static org.hibernate.annotations.OnDeleteAction.CASCADE;

@Getter
@Builder
public class Note {
    private Long noteId;
    private Member member;
    private String title;
    private String content;
    private String summary;

    public static Note createNote(Member member, String title, String content, String summary){
        return Note.builder()
                .member(member)
                .title(title)
                .content(content)
                .summary(summary)
                .build();
    }

    public void updateNote(String title, String content, String summary){
        this.title = title;
        this.content = content;
        this.summary = summary;
    }
}
