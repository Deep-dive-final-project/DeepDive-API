package org.deepdive.apiserver.lecture.application;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.deepdive.apiserver.common.dto.CommonSuccessDto;
import org.deepdive.apiserver.lecture.application.dto.request.CreateLectureRequestDto;
import org.deepdive.apiserver.lecture.application.dto.response.GetLectureListResponseDto;
import org.deepdive.apiserver.lecture.application.dto.response.GetLectureResponseDto;
import org.deepdive.apiserver.lecture.application.interfaces.LectureRepository;
import org.deepdive.apiserver.lecture.domain.lecture.Lecture;
import org.deepdive.apiserver.security.application.resolver.Login;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LectureService {

    private final LectureRepository lectureRepository;

    public GetLectureResponseDto getLecture(Long lectureId) {
        Lecture lecture = lectureRepository.findById(lectureId);
        return new GetLectureResponseDto(lecture.getLectureId(), lecture.getTitle());
    }

    public CommonSuccessDto saveLecture(CreateLectureRequestDto dto) {
        Lecture lecture = lectureRepository.findById(dto.LectureId);
        lectureRepository.save(lecture);
        return CommonSuccessDto.fromEntity(true);
    }

    public GetLectureListResponseDto getLectures(@Login Long memberId) {
        List<Lecture> lectures = lectureRepository.findAllByMemberId(memberId);
        return GetLectureListResponseDto.from(lectures);
    }
}
