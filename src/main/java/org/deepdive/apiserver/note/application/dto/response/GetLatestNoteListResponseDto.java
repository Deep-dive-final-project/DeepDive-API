package org.deepdive.apiserver.note.application.dto.response;


import java.util.List;
import org.deepdive.apiserver.note.domain.Note;

public record GetLatestNoteListResponseDto(List<GetLatestNoteResponseDto> getLatestNoteResponseDtoList) {
    public static GetLatestNoteListResponseDto fromEntity(List<Note> notes) {
        return new GetLatestNoteListResponseDto(notes.stream().map(GetLatestNoteResponseDto::fromEntity).toList());
    }
}
