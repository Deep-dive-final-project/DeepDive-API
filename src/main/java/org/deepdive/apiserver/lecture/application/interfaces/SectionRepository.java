package org.deepdive.apiserver.lecture.application.interfaces;

import java.util.List;
import org.deepdive.apiserver.lecture.domain.section.Section;

public interface SectionRepository {

    List<Section> findAllByLectureId(Long lectureId);
}
