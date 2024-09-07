package org.deepdive.apiserver.note.application.dto.request;

public record CreateNoteRequestDto(
        Long task_id,
        String title,
        String content,
        String summary
) {
}
