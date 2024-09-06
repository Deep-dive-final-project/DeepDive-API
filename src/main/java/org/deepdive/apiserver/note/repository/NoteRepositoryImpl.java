package org.deepdive.apiserver.note.repository;

import lombok.RequiredArgsConstructor;
import org.deepdive.apiserver.note.application.interfaces.NoteRepository;
import org.deepdive.apiserver.note.domain.Note;
import org.deepdive.apiserver.note.repository.entity.NoteEntity;
import org.deepdive.apiserver.note.repository.jpa.JpaNoteRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class NoteRepositoryImpl implements NoteRepository{
    private final JpaNoteRepository noteRepository;

    @Override
    public List<Note> findNotesByMember(Long memberId) {
        List<NoteEntity> entities = noteRepository.findNotesByMember(memberId);
        return entities.stream().map(NoteEntity::toNote).toList();
    }
}
