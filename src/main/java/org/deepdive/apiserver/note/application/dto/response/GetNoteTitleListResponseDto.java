package org.deepdive.apiserver.note.application.dto.response;

import java.util.List;
import java.util.stream.Collectors;
import org.deepdive.apiserver.note.domain.Note;

public record GetNoteTitleListResponseDto(List<GetNoteTitleResponseDto> contents) {

    public static GetNoteTitleListResponseDto from(List<Note> notes) {
        List<GetNoteTitleResponseDto> dtos = notes.stream()
            .map(note -> new GetNoteTitleResponseDto(note.getNoteId(), note.getTitle()))
            .collect(Collectors.toList());
        return new GetNoteTitleListResponseDto(dtos);
    }
}
