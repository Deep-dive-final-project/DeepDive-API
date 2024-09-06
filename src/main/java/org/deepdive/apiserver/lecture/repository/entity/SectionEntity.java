package org.deepdive.apiserver.lecture.repository.entity;

import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.util.List;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.deepdive.apiserver.lecture.domain.section.Section;

@Getter
@Entity
@Table(name = "section")
@NoArgsConstructor
public class SectionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long sectionId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "lecture_id")
    private LectureEntity lecture;

    private String name;

    @Convert(converter = StringToListConverter.class)
    private List<String> subSection;

    public SectionEntity(Section section) {
        this.sectionId = section.getSectionId();
        this.lecture = new LectureEntity(section.getLecture());
        this.name = section.getName();
        this.subSection = section.getSubSection();
    }

    public Section toSection() {
        return Section.builder()
            .sectionId(sectionId)
            .lecture(lecture.toLecture())
            .name(name)
            .subSection(subSection)
            .build();
    }
}
