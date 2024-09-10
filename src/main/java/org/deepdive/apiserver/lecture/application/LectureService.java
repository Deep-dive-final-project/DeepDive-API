package org.deepdive.apiserver.lecture.application;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.deepdive.apiserver.common.dto.CommonSuccessDto;
import org.deepdive.apiserver.lecture.application.dto.request.CreateLectureRequestDto;
import org.deepdive.apiserver.lecture.application.dto.response.GetLectureListResponseDto;
import org.deepdive.apiserver.lecture.application.dto.response.GetLectureResponseDto;
import org.deepdive.apiserver.lecture.application.interfaces.LectureRepository;
import org.deepdive.apiserver.lecture.domain.lecture.Lecture;
import org.deepdive.apiserver.security.application.service.MemberService;
import org.deepdive.apiserver.security.application.resolver.Login;
import org.deepdive.apiserver.security.domain.Member;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class LectureService {

    private final LectureRepository lectureRepository;
    private final MemberService memberService;

    public Lecture getLecture(Long lectureId) {
        return lectureRepository.findById(lectureId);
    }

    public GetLectureResponseDto findLecture(Long lectureId) {
        Lecture lecture = getLecture(lectureId);
        return new GetLectureResponseDto(lecture.getLectureId(), lecture.getTitle());
    }

    @Transactional
    public CommonSuccessDto saveLecture(CreateLectureRequestDto dto) {
        Lecture lecture = getLecture(dto.LectureId);
        lectureRepository.save(lecture);
        return CommonSuccessDto.fromEntity(true);
    }

    public GetLectureListResponseDto findLectures(@Login Long memberId) {
        Member member = memberService.getMember(memberId);
        List<Lecture> lectures = lectureRepository.findAllByMemberId(member);
        return GetLectureListResponseDto.from(lectures);
    }
}
