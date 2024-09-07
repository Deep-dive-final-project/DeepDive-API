package org.deepdive.apiserver.lecture.application;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.deepdive.apiserver.lecture.application.interfaces.SectionRepository;
import org.deepdive.apiserver.lecture.domain.lecture.Lecture;
import org.deepdive.apiserver.lecture.domain.section.Section;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class SectionService {

    private final SectionRepository sectionRepository;
    private final LectureService lectureService;

    public List<Section> findSectionNames(Long lectureId) {
        Lecture lecture = lectureService.getLecture(lectureId);
        return sectionRepository.findAllByLectureId(lecture);
    }
}
