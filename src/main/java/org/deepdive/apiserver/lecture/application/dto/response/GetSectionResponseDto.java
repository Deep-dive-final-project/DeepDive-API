package org.deepdive.apiserver.lecture.application.dto.response;

public record GetSectionResponseDto(String subSectionName) {

    public GetSectionResponseDto(String subSectionName) {
        this.subSectionName = subSectionName;
    }
}
