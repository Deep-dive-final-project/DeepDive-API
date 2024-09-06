package org.deepdive.apiserver.lecture.domain.lecture;

import lombok.Getter;

@Getter
public class Url  {

    String text;

    public Url(String text) {
        this.text = text;
    }
}
