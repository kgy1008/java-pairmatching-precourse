package pairmatching.domain.crew;

import java.util.List;
import pairmatching.domain.curriculum.Course;

public class Crews {

    private final List<Crew> crews;

    public Crews(final List<Crew> crews) {
        this.crews = crews;
    }

    public List<String> findNameByCourse(final Course course) {
        return crews.stream()
                .filter(crew -> crew.isEqualCourse(course))
                .map(Crew::getName)
                .toList();
    }
}
