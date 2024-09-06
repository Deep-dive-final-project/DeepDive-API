package org.deepdive.apiserver.note.application.dto.response;

import lombok.Builder;
import org.deepdive.apiserver.note.domain.Note;

@Builder
public record GetNoteResponseDto(
        String content,
        String summary
) {
    public static GetNoteResponseDto fromEntity(Note note){
        return GetNoteResponseDto.builder()
                .content(note.getContent())
                .summary(note.getSummary())
                .build();
    }
}
