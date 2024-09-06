package org.deepdive.apiserver.lecture.domain.lecture.stringlist;

import java.util.List;
import lombok.Getter;

@Getter
public class Goals extends StringList{

    public Goals(List<String> goals) {
        super(goals);
    }
}
