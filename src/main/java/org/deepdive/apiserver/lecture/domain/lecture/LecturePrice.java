package org.deepdive.apiserver.lecture.domain.lecture;

import lombok.Getter;

@Getter
public class LecturePrice {

    private int price;

    public LecturePrice(int price) {
        checkPrice();
        this.price = price;
    }

    public void checkPrice() {
        if (price < 0) {
            throw new IllegalArgumentException();
        }
    }
}
