package org.deepdive.apiserver.lecture.repository;

import lombok.RequiredArgsConstructor;
import org.deepdive.apiserver.common.exception.CommonException;
import org.deepdive.apiserver.common.exception.ErrorCode;
import org.deepdive.apiserver.lecture.application.interfaces.LectureRepository;
import org.deepdive.apiserver.lecture.domain.Lecture;
import org.deepdive.apiserver.lecture.repository.entity.LectureEntity;
import org.deepdive.apiserver.lecture.repository.jpa.JpaLectureRepository;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class LectureRepositoryImpl implements LectureRepository {

    private final JpaLectureRepository lectureRepository;

    @Override
    public Lecture findById(Long id) {
        LectureEntity entity = lectureRepository.findById(id)
            .orElseThrow(() -> new CommonException(ErrorCode.NOT_FOUND_LECTURE));
        return entity.toLecture();
    }

    @Override
    public Lecture save(Lecture lecture) {
        LectureEntity entity = lectureRepository.save(new LectureEntity(lecture));
        return entity.toLecture();
    }
}
