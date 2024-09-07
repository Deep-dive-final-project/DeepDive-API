package org.deepdive.apiserver.note.application;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.deepdive.apiserver.common.dto.CommonSuccessDto;
import org.deepdive.apiserver.common.exception.CommonException;
import org.deepdive.apiserver.common.exception.ErrorCode;
import org.deepdive.apiserver.note.application.dto.request.CreateNoteRequestDto;
import org.deepdive.apiserver.note.application.dto.request.UpdateNoteRequestDto;
import org.deepdive.apiserver.note.application.dto.response.GetNoteListResponseDto;
import org.deepdive.apiserver.note.application.dto.response.GetNoteResponseDto;
import org.deepdive.apiserver.note.application.interfaces.NoteRepository;
import org.deepdive.apiserver.note.domain.Note;
import org.deepdive.apiserver.security.application.MemberService;
import org.deepdive.apiserver.security.domain.Member;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional(readOnly = true)
public class NoteService {

    private final NoteRepository noteRepository;
    private final MemberService memberService;

    public List<GetNoteListResponseDto> getNoteList(Long memberId){
        List<Note> notes = noteRepository.findNotesByMember(memberId);

        return notes.stream().map(GetNoteListResponseDto::fromEntity).toList();
    }

    public GetNoteResponseDto getNote(Long memberId, Long noteId) {
        Note note = noteRepository.findById(noteId);
        return GetNoteResponseDto.fromEntity(note);
    }

    @Transactional
    public CommonSuccessDto createNote(Long memberId, CreateNoteRequestDto dto){
        Note note = Note.createNote(memberService.getMember(memberId),
                dto.title(), dto.content(), dto.summary());
        noteRepository.save(note);
        return CommonSuccessDto.fromEntity(true);
    }

    @Transactional
    public CommonSuccessDto updateNote(Long memberId, Long noteId, UpdateNoteRequestDto dto){
        Member member = memberService.getMember(memberId);
        Note note = noteRepository.findById(noteId);
        note.updateNote(dto.title(), dto.content(), dto.summary());
        noteRepository.update(note, member);
        return CommonSuccessDto.fromEntity(true);
    }

    @Transactional
    public CommonSuccessDto deleteNote(Long memberId, Long noteId) {
        Member member = memberService.getMember(memberId);
        Note note = noteRepository.findById(noteId);
        noteRepository.delete(note, member);
        return CommonSuccessDto.fromEntity(true);
    }
}
