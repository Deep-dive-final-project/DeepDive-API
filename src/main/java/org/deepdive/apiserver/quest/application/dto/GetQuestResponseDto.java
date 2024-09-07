package org.deepdive.apiserver.quest.application.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDate;

public record GetQuestResponseDto(Long id, String name, String content, String answer, String feedback,
                                  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
                                  LocalDate createdDate) {

    public GetQuestResponseDto(Long id, String name, String content, String answer, String feedback,
        LocalDate createdDate) {
        this.id = id;
        this.name = name;
        this.content = content;
        this.answer = answer;
        this.feedback = feedback;
        this.createdDate = createdDate;
    }
}
