package org.deepdive.apiserver.note.repository;

import lombok.RequiredArgsConstructor;
import org.deepdive.apiserver.note.application.interfaces.NoteRepository;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class NoteRepositoryImpl implements NoteRepository{
}
