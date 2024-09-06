package org.deepdive.apiserver.lecture.repository;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.deepdive.apiserver.common.exception.CommonException;
import org.deepdive.apiserver.common.exception.ErrorCode;
import org.deepdive.apiserver.lecture.application.interfaces.LectureRepository;
import org.deepdive.apiserver.lecture.domain.lecture.Lecture;
import org.deepdive.apiserver.lecture.repository.entity.LectureEntity;
import org.deepdive.apiserver.lecture.repository.entity.MyLectureEntity;
import org.deepdive.apiserver.lecture.repository.jpa.JpaLectureCommandRepository;
import org.deepdive.apiserver.lecture.repository.jpa.JpaLectureQueryRepository;
import org.deepdive.apiserver.lecture.repository.jpa.JpaMyLectureQueryRepository;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class LectureRepositoryImpl implements LectureRepository {

    private final JpaLectureQueryRepository queryRepository;
    private final JpaLectureCommandRepository commandRepository;
    private final JpaMyLectureQueryRepository myLectureQueryRepository;

    @Override
    public List<Lecture> findAllByMemberId(Long memberId) {
        List<MyLectureEntity> myLectures = myLectureQueryRepository.findAllByMemberId(memberId);
        List<Long> ids = myLectures.stream().map(MyLectureEntity::getLectureId).toList();
        List<LectureEntity> entities = queryRepository.findAllInMyLectureIds(ids);
        return entities.stream().map(LectureEntity::toLecture).toList();
    }

    @Override
    public Lecture findById(Long id) {
        LectureEntity entity = queryRepository.findById(id)
            .orElseThrow(() -> new CommonException(ErrorCode.NOT_FOUND_LECTURE));
        return entity.toLecture();
    }

    @Override
    public Lecture save(Lecture lecture) {
        LectureEntity entity = commandRepository.save(new LectureEntity(lecture));
        return entity.toLecture();
    }
}
