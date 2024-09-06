package org.deepdive.apiserver.lecture.domain.section;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import org.deepdive.apiserver.lecture.domain.lecture.Lecture;

@Getter
@Builder
@AllArgsConstructor
public class Section {

    private Long sectionId;
    private Lecture lecture;
    private String name;
    private List<String> subSection;
}
