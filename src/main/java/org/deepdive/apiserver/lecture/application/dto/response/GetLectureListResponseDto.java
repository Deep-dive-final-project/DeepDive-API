package org.deepdive.apiserver.lecture.application.dto.response;

import java.util.List;
import java.util.stream.Collectors;
import org.deepdive.apiserver.lecture.domain.lecture.Lecture;

public record GetLectureListResponseDto(List<GetLectureResponseDto> contents) {

    public static GetLectureListResponseDto from(List<Lecture> lectures) {
        List<GetLectureResponseDto> dtos = lectures.stream()
            .map(lecture -> new GetLectureResponseDto(lecture.getLectureId(), lecture.getTitle()))
            .collect(Collectors.toList());
        return new GetLectureListResponseDto(dtos);
    }
}
