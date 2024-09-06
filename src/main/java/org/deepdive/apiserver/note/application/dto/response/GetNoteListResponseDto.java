package org.deepdive.apiserver.note.application.dto.response;

import lombok.Builder;
import org.deepdive.apiserver.note.domain.Note;

@Builder
public record GetNoteListResponseDto(
        Long noteId,
        String title
) {
    public static GetNoteListResponseDto fromEntity(Note note){
        return GetNoteListResponseDto.builder()
                .noteId(note.getNoteId())
                .title(note.getTitle())
                .build();
    }
}
