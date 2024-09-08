package org.deepdive.apiserver.quest.application.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.sql.Timestamp;

public record GetQuestDetailResponseDto(String name, String content, String answer, String feedback,
                                  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
                                  Timestamp createdDate) {

    public GetQuestDetailResponseDto(String name, String content, String answer, String feedback,
        Timestamp createdDate) {
        this.name = name;
        this.content = content;
        this.answer = answer;
        this.feedback = feedback;
        this.createdDate = createdDate;
    }
}