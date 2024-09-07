package org.deepdive.apiserver.note.domain;

import lombok.Builder;
import lombok.Getter;
import org.deepdive.apiserver.plan.domain.Task;
import org.deepdive.apiserver.security.domain.Member;

@Getter
@Builder
public class Note {
    private Long noteId;
    private Member member;
    private Task task;
    private String title;
    private String content;
    private String summary;

    public static Note createNote(Member member, Task task, String title, String content, String summary){
        return Note.builder()
                .member(member)
                .task(task)
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
