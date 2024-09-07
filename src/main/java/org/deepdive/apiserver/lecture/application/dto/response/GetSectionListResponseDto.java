package org.deepdive.apiserver.lecture.application.dto.response;

import java.util.List;
import org.deepdive.apiserver.lecture.domain.section.Section;

public record GetSectionListResponseDto(List<GetSectionResponseDto> contents) {

    public static GetSectionListResponseDto from(List<Section> sections) {
        List<GetSectionResponseDto> dtos = sections.stream()
            .map(section -> new GetSectionResponseDto(section.getName()))
            .toList();
        return new GetSectionListResponseDto(dtos);
    }
}
