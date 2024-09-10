package org.deepdive.apiserver.note.application.dto.response;

import java.sql.Timestamp;
import lombok.Builder;
import org.deepdive.apiserver.note.domain.Note;

@Builder
public record GetLatestNoteResponseDto(Long noteId, String title, Timestamp completeDate) {
    public static GetLatestNoteResponseDto fromEntity(Note note) {
        return GetLatestNoteResponseDto.builder()
                .noteId(note.getNoteId())
                .title(note.getTitle())
                .completeDate(note.getTask().getCompleteDate())
                .build();
    }
}
