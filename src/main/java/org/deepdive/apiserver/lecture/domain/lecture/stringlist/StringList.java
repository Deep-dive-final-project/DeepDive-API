package org.deepdive.apiserver.lecture.domain.lecture.stringlist;

import java.util.List;
import lombok.Getter;

@Getter
public abstract class StringList {

    protected final List<String> values;

    public StringList(List<String> values) {
        this.values = values;
    }
}
