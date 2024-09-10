package org.deepdive.apiserver.note.application.dto.response;

import lombok.Builder;

@Builder
public record GetNoteTitleResponseDto(
        Long noteId,
        String title
) {

    public GetNoteTitleResponseDto(Long noteId, String title) {
        this.noteId = noteId;
        this.title = title;
    }
}
