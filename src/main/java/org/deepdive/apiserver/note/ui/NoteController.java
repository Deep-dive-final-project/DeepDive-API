package org.deepdive.apiserver.note.ui;

import lombok.RequiredArgsConstructor;
import org.deepdive.apiserver.common.dto.CommonSuccessDto;
import org.deepdive.apiserver.common.dto.ResponseDto;
import org.deepdive.apiserver.note.application.NoteService;
import org.deepdive.apiserver.note.application.dto.request.CreateNoteRequestDto;
import org.deepdive.apiserver.note.application.dto.request.UpdateNoteRequestDto;
import org.deepdive.apiserver.note.application.dto.response.GetNoteListResponseDto;
import org.deepdive.apiserver.security.application.resolver.Login;
import org.deepdive.apiserver.note.application.dto.response.GetNoteResponseDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/{note_id}")
    public ResponseDto<GetNoteResponseDto> getNote(@Login Long memberId, @PathVariable("note_id") Long noteId){
        return ResponseDto.ok(noteService.getNote(memberId, noteId));
    }

    @PostMapping("")
    public CommonSuccessDto createNote(@Login Long memberId, @RequestBody CreateNoteRequestDto createNoteRequestDto){
        noteService.createNote(memberId, createNoteRequestDto);
        return CommonSuccessDto.fromEntity(true);
    }

    @PatchMapping("/{note_id}")
    public CommonSuccessDto updateNote(@Login Long memberId, @RequestBody UpdateNoteRequestDto dto, @PathVariable("note_id") Long noteId){
        noteService.updateNote(memberId, noteId, dto);
        return CommonSuccessDto.fromEntity(true);
    }

    @DeleteMapping("/{note_id}")
    public CommonSuccessDto deleteNote(@Login Long memberId, @PathVariable("note_id") Long noteId){
        noteService.deleteNote(memberId, noteId);
        return CommonSuccessDto.fromEntity(true);
    }
}
