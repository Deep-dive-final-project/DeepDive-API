package org.deepdive.apiserver.note.application.interfaces;

import org.deepdive.apiserver.note.domain.Note;
import org.deepdive.apiserver.security.entity.Member;

import java.util.List;

public interface NoteRepository {

    List<Note> findNotesByMember(Long memberId);

    Note findById(Long noteId);
}
