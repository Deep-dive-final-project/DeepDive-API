package org.deepdive.apiserver.lecture.domain.lecture;

import java.math.BigDecimal;
import java.util.List;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
    public class Lecture {

        private Long lectureId;
        private LectureInfo info;
        private Url lectureUrl;
        private Url imageUrl;
        private Rating rating;
        private LecturePrice price;

        public String getTitle() {
            return info.getTitle();
        }

        public String getInstructor() {
            return info.getInstructor();
        }

        public List<String> getGoals() {
        return info.getGoals();
    }

    public List<String> getTargets() {
        return info.getTargets();
    }

    public BigDecimal getRating() {
        return this.rating.getValue();
    }

    public String getLectureUrl() {
        return lectureUrl.getText();
    }

    public String getImageUrl() {
        return imageUrl.getText();
    }

    public LectureInfo getLectureInfo() {
        return this.info;
    }
}
