package org.deepdive.apiserver.note.repository.jpa;

import org.deepdive.apiserver.note.domain.Note;
import org.deepdive.apiserver.note.repository.entity.NoteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface JpaNoteRepository extends JpaRepository<NoteEntity, Long> {

    @Query( "select n from NoteEntity n" +
            " join fetch n.member m" +
            " where m.id = :memberId")
    List<Note> findNotesByMember(@Param("memberId") Long memberId);
}
