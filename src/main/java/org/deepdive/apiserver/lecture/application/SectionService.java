package org.deepdive.apiserver.lecture.application;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.deepdive.apiserver.lecture.application.interfaces.SectionRepository;
import org.deepdive.apiserver.lecture.domain.section.Section;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SectionService {

    private final SectionRepository sectionRepository;

    public List<Section> findSectionNames(Long lectureId) {
        return sectionRepository.findAllByLectureId(lectureId);
    }
}
