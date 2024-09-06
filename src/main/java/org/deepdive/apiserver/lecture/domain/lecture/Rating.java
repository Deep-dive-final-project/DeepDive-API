package org.deepdive.apiserver.lecture.domain.lecture;

import java.math.BigDecimal;
import lombok.Getter;

@Getter
public class Rating {

    private BigDecimal value;

    public Rating(BigDecimal value) {
        checkRating(value);
        this.value = value;
    }

    public void checkRating(BigDecimal rating) {
        if (rating.compareTo(BigDecimal.ZERO) < 0 || rating.compareTo(BigDecimal.valueOf(5)) > 0) {
            throw new IllegalArgumentException();
        }
    }
}
