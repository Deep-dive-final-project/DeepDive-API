package org.deepdive.apiserver.note.application.interfaces;

import org.deepdive.apiserver.note.domain.Note;
import org.deepdive.apiserver.security.domain.Member;

import java.util.List;

public interface NoteRepository {

    List<Note> findNotesByMember(Long memberId);

    Note findById(Long noteId);

    void save(Note note);

    void update(Note note, Member member);

    void delete(Note note, Member member);
}
