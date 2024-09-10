package org.deepdive.apiserver.note.application;

import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.deepdive.apiserver.common.dto.CommonSuccessDto;
import org.deepdive.apiserver.note.application.dto.request.CreateNoteRequestDto;
import org.deepdive.apiserver.note.application.dto.request.UpdateNoteRequestDto;
import org.deepdive.apiserver.note.application.dto.response.GetLatestNoteResponseDto;
import org.deepdive.apiserver.note.application.dto.response.GetNoteResponseDto;
import org.deepdive.apiserver.note.application.dto.response.GetNoteTitleListResponseDto;
import org.deepdive.apiserver.note.application.interfaces.NoteRepository;
import org.deepdive.apiserver.note.domain.Note;
import org.deepdive.apiserver.plan.application.TaskService;
import org.deepdive.apiserver.plan.domain.Task;
import org.deepdive.apiserver.security.application.service.MemberService;
import org.deepdive.apiserver.security.domain.Member;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional(readOnly = true)
public class NoteService {

    private final NoteRepository noteRepository;
    private final MemberService memberService;
    private final TaskService taskService;

    public GetNoteTitleListResponseDto getNoteList(Long memberId) {
        Member member = memberService.getMember(memberId);
        List<Note> notes = noteRepository.findNotesByMember(member);
        return GetNoteTitleListResponseDto.from(notes);
    }

    public GetNoteResponseDto getNote(Long memberId, Long noteId) {
        Note note = noteRepository.findById(noteId);
        return GetNoteResponseDto.fromEntity(note);
    }

    @Transactional
    public CommonSuccessDto createNote(Long memberId, CreateNoteRequestDto dto) {
        Member member = memberService.getMember(memberId);
        Task task = taskService.findTask(dto.task_id());
        Note note = Note.createNote(member, task, dto.title(), dto.content(), dto.summary());
        noteRepository.save(note);
        return CommonSuccessDto.fromEntity(true);
    }

    @Transactional
    public CommonSuccessDto updateNote(Long memberId, Long noteId, UpdateNoteRequestDto dto) {
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

    public List<GetLatestNoteResponseDto> getLatestNoteList(Long memberId) {
        List<Note> notes = noteRepository.findLatestNotesByMember(memberId);
        return notes.stream().map(GetLatestNoteResponseDto::fromEntity).toList();
    }
}
