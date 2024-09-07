package org.deepdive.apiserver.lecture.domain.section.subsection;

import java.util.List;
import lombok.Getter;

@Getter
public class SubSections {

    private List<SubSection> subSections;

    public SubSections(List<SubSection> subSections) {
        this.subSections = subSections;
    }
}
