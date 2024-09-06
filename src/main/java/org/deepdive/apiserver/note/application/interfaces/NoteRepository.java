package org.deepdive.apiserver.note.application.interfaces;

import org.deepdive.apiserver.note.domain.Note;

import java.util.List;

public interface NoteRepository {

    List<Note> findNotesByMember(Long memberId);
}
