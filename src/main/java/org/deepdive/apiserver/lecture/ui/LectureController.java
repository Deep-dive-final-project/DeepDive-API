package org.deepdive.apiserver.lecture.ui;

import lombok.RequiredArgsConstructor;
import org.deepdive.apiserver.lecture.application.LectureService;
import org.deepdive.apiserver.lecture.application.dto.response.GetLectureListResponseDto;
import org.deepdive.apiserver.lecture.application.dto.response.GetLectureResponseDto;
import org.deepdive.apiserver.security.application.resolver.Login;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/lecture")
@RequiredArgsConstructor
public class LectureController {

    private final LectureService courseService;

    @GetMapping("")
    public ResponseEntity<GetLectureListResponseDto> getLectures(@Login Long userId) {
        return ResponseEntity.ok(courseService.findLectures(userId));
    }

    @GetMapping("/{lectureId}")
    public ResponseEntity<GetLectureResponseDto> getLecture(@Login Long userId,
        @PathVariable("lectureId") Long lectureId) {
        return ResponseEntity.ok(courseService.findLecture(lectureId));
    }
}
