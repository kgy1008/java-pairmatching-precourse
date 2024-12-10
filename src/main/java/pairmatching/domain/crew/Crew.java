package pairmatching.domain.crew;

import pairmatching.domain.curriculum.Course;

public class Crew {

    private final String name;
    private final Course course;

    public Crew(final String name, final Course course) {
        this.name = name;
        this.course = course;
    }
}
