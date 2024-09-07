package org.deepdive.apiserver.note.application.dto.request;

public record UpdateNoteRequestDto(
        String title,
        String content,
        String summary
) {
}
