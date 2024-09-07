package org.deepdive.apiserver.lecture.ui;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.deepdive.apiserver.common.dto.ResponseDto;
import org.deepdive.apiserver.lecture.application.SectionService;
import org.deepdive.apiserver.lecture.application.dto.response.GetSectionListResponseDto;
import org.deepdive.apiserver.lecture.domain.section.Section;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/lecture")
@RequiredArgsConstructor
public class SectionController {

    private final SectionService sectionService;

    @GetMapping("/{lecture_id}/section")
    public ResponseDto<GetSectionListResponseDto> getSectionNames(@PathVariable("lecture_id") Long lectureId) {
        List<Section> sections = sectionService.findSectionNames(lectureId);
        return ResponseDto.ok(GetSectionListResponseDto.from(sections));
    }
}
