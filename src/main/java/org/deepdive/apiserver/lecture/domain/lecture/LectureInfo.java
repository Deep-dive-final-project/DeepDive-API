package org.deepdive.apiserver.lecture.domain.lecture;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.deepdive.apiserver.lecture.domain.lecture.stringlist.Goals;
import org.deepdive.apiserver.lecture.domain.lecture.stringlist.Targets;

@Getter
@AllArgsConstructor
public class LectureInfo {

    private String title;
    private String instructor;
    private Goals goals;
    private Targets targets;

    public List<String> getGoals() {
        return goals.getValues();
    }

    public List<String> getTargets() {
        return targets.getValues();
    }
}
