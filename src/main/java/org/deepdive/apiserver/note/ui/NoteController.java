package org.deepdive.apiserver.note.ui;

import lombok.RequiredArgsConstructor;
import org.deepdive.apiserver.common.dto.ResponseDto;
import org.deepdive.apiserver.note.application.NoteService;
import org.deepdive.apiserver.note.application.dto.response.GetNoteListResponseDto;
import org.deepdive.apiserver.security.resolver.Login;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/api/note")
@RequiredArgsConstructor
public class NoteController {

    private final NoteService noteService;

    @GetMapping("")
    public ResponseDto<List<GetNoteListResponseDto>> getNoteList(@Login Long memberId){

        return ResponseDto.ok(noteService.getNoteList(memberId));
    }
}
