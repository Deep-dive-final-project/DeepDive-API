package org.deepdive.apiserver.lecture.ui;

import lombok.RequiredArgsConstructor;
import org.deepdive.apiserver.common.dto.CommonSuccessDto;
import org.deepdive.apiserver.lecture.application.dto.request.CreateLectureRequestDto;
import org.deepdive.apiserver.lecture.application.dto.response.GetLectureResponseDto;
import org.deepdive.apiserver.lecture.application.LectureService;
import org.deepdive.apiserver.security.resolver.Login;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/course")
@RequiredArgsConstructor
public class LectureController {

    private final LectureService courseService;

//    @GetMapping("/{courseId}")
//    public ResponseEntity<GetLectureResponseDto> getCourse(@Login Long userId, @PathVariable("courseId") Long courseId) {
//        return ResponseEntity.ok(courseService.getLecture(courseId));
//    }

//    @PostMapping
//    public CommonSuccessDto saveLecture(@RequestBody CreateLectureRequestDto dto) {
//        courseService.saveLecture(dto);
//    }
}
