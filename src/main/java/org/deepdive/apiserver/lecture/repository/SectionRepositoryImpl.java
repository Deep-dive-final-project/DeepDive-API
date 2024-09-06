package org.deepdive.apiserver.lecture.repository;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.deepdive.apiserver.lecture.application.interfaces.SectionRepository;
import org.deepdive.apiserver.lecture.domain.section.Section;
import org.deepdive.apiserver.lecture.repository.entity.SectionEntity;
import org.deepdive.apiserver.lecture.repository.jpa.JpaSectionQueryRepository;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class SectionRepositoryImpl implements SectionRepository {

    private final JpaSectionQueryRepository queryRepository;


    @Override
    public List<Section> findAllByLectureId(Long lectureId) {
        List<SectionEntity> entities = queryRepository.findAllByLectureId(lectureId);
        return entities.stream().map(SectionEntity::toSection).toList();
    }
}
