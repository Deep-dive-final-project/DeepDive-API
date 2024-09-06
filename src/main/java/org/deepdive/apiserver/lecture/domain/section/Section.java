package org.deepdive.apiserver.lecture.domain.section;

import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import org.deepdive.apiserver.lecture.domain.lecture.Lecture;
import org.deepdive.apiserver.lecture.repository.entity.StringToListConverter;

@Getter
@Builder
@AllArgsConstructor
public class Section {

    private Long sectionId;
    private Lecture lecture;
    private String name;

    @Convert(converter = StringToListConverter.class)
    @Column(name = "subsections", columnDefinition = "TEXT")
    private List<String> subSection;
}
