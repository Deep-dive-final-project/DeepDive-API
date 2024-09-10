package org.deepdive.apiserver.note.repository.jpa;

import java.sql.Timestamp;
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

    @Query("select n from NoteEntity n" +
            " join fetch n.member m" +
            " where m.memberId = :memberId"+
            " order by n.noteId desc" +
            " limit 10")
    List<NoteEntity> findLatestNotesByMember(@Param("memberId") Long memberId);

    @Query( "select n from NoteEntity n" +
            " join fetch n.member m " +
            "where n.noteId = :noteId")
    Optional<NoteEntity> findById(@Param("noteId") Long noteId);
}
