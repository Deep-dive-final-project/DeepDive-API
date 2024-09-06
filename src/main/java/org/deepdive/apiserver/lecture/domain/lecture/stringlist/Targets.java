package org.deepdive.apiserver.lecture.domain.lecture.stringlist;

import java.util.List;
import lombok.Getter;

@Getter
public class Targets extends StringList{

    public Targets(List<String> targets) {
        super(targets);
    }
}
