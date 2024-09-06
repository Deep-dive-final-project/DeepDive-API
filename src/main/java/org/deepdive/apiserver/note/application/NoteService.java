package org.deepdive.apiserver.note.application;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.deepdive.apiserver.note.application.dto.response.GetNoteListResponseDto;
import org.deepdive.apiserver.note.application.interfaces.NoteRepository;
import org.deepdive.apiserver.note.domain.Note;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class NoteService {

    private final NoteRepository noteRepository;

    public List<GetNoteListResponseDto> getNoteList(Long memberId){
        List<Note> notes = noteRepository.findNotesByMember(memberId);

        return notes.stream().map(GetNoteListResponseDto::fromEntity).toList();
    }
}
