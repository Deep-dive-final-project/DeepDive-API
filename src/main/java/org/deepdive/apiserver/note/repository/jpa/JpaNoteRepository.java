package org.deepdive.apiserver.note.repository.jpa;

import org.deepdive.apiserver.note.repository.entity.NoteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface JpaNoteRepository extends JpaRepository<NoteEntity, Long> {

    @Query( "select n from NoteEntity n" +
            " join fetch n.member m" +
            " where m.memberId = :memberId")
    List<NoteEntity> findNotesByMember(@Param("memberId") Long memberId);

    @Query( "select n from NoteEntity n" +
            " join fetch n.member m " +
            "where n.noteId = :noteId")
    Optional<NoteEntity> findById(@Param("noteId") Long noteId);
}
