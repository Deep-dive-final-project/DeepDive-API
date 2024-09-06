package org.deepdive.apiserver.lecture.repository;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.deepdive.apiserver.lecture.application.interfaces.SectionRepository;
import org.deepdive.apiserver.lecture.domain.lecture.Lecture;
import org.deepdive.apiserver.lecture.domain.section.Section;
import org.deepdive.apiserver.lecture.repository.entity.SectionEntity;
import org.deepdive.apiserver.lecture.repository.jpa.JpaSectionQueryRepository;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class SectionRepositoryImpl implements SectionRepository {

    private final JpaSectionQueryRepository queryRepository;


    @Override
    public List<Section> findAllByLectureId(Lecture lecture) {
        List<SectionEntity> entities = queryRepository.findAllByLectureId(lecture.getLectureId());
        return entities.stream().map(SectionEntity::toSection).toList();
    }
}
