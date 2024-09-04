package org.deepdive.apiserver.lecture.application;

import lombok.RequiredArgsConstructor;
import org.deepdive.apiserver.common.dto.CommonSuccessDto;
import org.deepdive.apiserver.lecture.application.dto.request.CreateLectureRequestDto;
import org.deepdive.apiserver.lecture.application.dto.response.GetLectureResponseDto;
import org.deepdive.apiserver.lecture.application.interfaces.LectureRepository;
import org.deepdive.apiserver.lecture.domain.Lecture;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LectureService {

    private final LectureRepository lectureRepository;

    public GetLectureResponseDto getLecture(Long lectureId) {
        Lecture lecture = lectureRepository.findById(lectureId);
        return GetLectureResponseDto.fromEntity(lecture);
    }

    public CommonSuccessDto saveLecture(CreateLectureRequestDto dto) {
        Lecture lecture = lectureRepository.findById(dto.LectureId);
        lectureRepository.save(lecture);
        return CommonSuccessDto.fromEntity(true);
    }
}
