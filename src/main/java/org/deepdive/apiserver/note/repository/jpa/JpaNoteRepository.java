package org.deepdive.apiserver.note.repository.jpa;

import org.deepdive.apiserver.note.domain.Note;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaNoteRepository extends JpaRepository<Note, Long> {
}
