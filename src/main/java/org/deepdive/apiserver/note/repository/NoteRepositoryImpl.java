package org.deepdive.apiserver.note.repository;

import lombok.RequiredArgsConstructor;
import org.deepdive.apiserver.common.exception.CommonException;
import org.deepdive.apiserver.common.exception.ErrorCode;
import org.deepdive.apiserver.note.application.interfaces.NoteRepository;
import org.deepdive.apiserver.note.domain.Note;
import org.deepdive.apiserver.note.repository.entity.NoteEntity;
import org.deepdive.apiserver.note.repository.jpa.JpaNoteRepository;
import org.deepdive.apiserver.security.entity.Member;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class NoteRepositoryImpl implements NoteRepository{
    private final JpaNoteRepository noteRepository;

    @Override
    public List<Note> findNotesByMember(Long memberId) {
        List<Note> notes = noteRepository.findNotesByMember(memberId);
        return notes;
    }

    @Override
    public Note findById(Long noteId) {
        NoteEntity entity = noteRepository.findById(noteId)
                .orElseThrow(() -> new CommonException(ErrorCode.NOT_FOUND_NOTE));
        return entity.toNote();
    }

    @Override
    public void save(Note note) {
        NoteEntity noteEntity = new NoteEntity(note);
        noteRepository.save(noteEntity);
    }

    @Override
    public void update(Note note, Member member) {
        if(note.getMember() != member){
            throw new CommonException(ErrorCode.ACCESS_DENIED_NOTE);
        }
        NoteEntity entity = noteRepository.findById(note.getNoteId()).orElseThrow(()-> new CommonException(ErrorCode.NOT_FOUND_NOTE));
        entity.update(note.getTitle(), note.getContent(), note.getSummary());
    }
}
