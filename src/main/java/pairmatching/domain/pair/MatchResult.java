package pairmatching.domain.pair;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import pairmatching.domain.curriculum.Course;
import pairmatching.domain.curriculum.Level;
import pairmatching.domain.curriculum.Mission;

public class MatchResult {

    private final Course course;
    private final Level level;
    private final Mission mission;
    private final Pairs pairs;

    public MatchResult(final Course course, final Level level, final Mission mission, final Pairs pairs) {
        this.course = course;
        this.level = level;
        this.mission = mission;
        this.pairs = pairs;
    }

    public boolean validateDuplicated(final List<String> target) {
        Set<String> names = new HashSet<>(target);
        return pairs.checkDuplicated(names);
    }

    public boolean isExist(final Level level) {
        return this.level == level;
    }

    public boolean isExist(final Course course, final Level level, final Mission mission) {
        return this.course == course && this.level == level && this.mission == mission;
    }

    public Pairs getPairs() {
        return pairs;
    }
}
