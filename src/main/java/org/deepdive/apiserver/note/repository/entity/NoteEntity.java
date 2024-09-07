package org.deepdive.apiserver.note.repository.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.deepdive.apiserver.note.domain.Note;
import org.deepdive.apiserver.security.repository.entity.MemberEntity;
import org.hibernate.annotations.OnDelete;

import static jakarta.persistence.FetchType.LAZY;
import static org.hibernate.annotations.OnDeleteAction.CASCADE;

@Getter
@Entity
@NoArgsConstructor
@Table(name = "note")
public class NoteEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "note_id")
    private Long noteId;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "member_id")
    @OnDelete(action = CASCADE)
    private MemberEntity member;

    //Task 테이블

    @NotNull
    @Column(name = "title")
    private String title;

    @NotNull
    @Column(name = "content")
    private String content;

    @Column(name = "summary")
    private String summary;

    public NoteEntity(Note note){
        this.member = new MemberEntity(note.getMember());
        this.title = note.getTitle();
        this.content = note.getContent();
        this.summary = note.getSummary();
    }

    public void update(String title, String content, String summary){
        this.title = title;
        this.content = content;
        this.summary = summary;
    }

    public static Note toNote(NoteEntity entity){
        return Note.builder()
                .noteId(entity.getNoteId())
                .member(entity.getMember().toMember())
                .title(entity.getTitle())
                .content(entity.getContent())
                .summary(entity.getSummary())
                .build();
    }
}
