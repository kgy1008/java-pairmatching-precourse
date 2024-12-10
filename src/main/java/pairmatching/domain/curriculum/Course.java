package pairmatching.domain.curriculum;

import java.util.Arrays;
import pairmatching.common.ErrorMessage;

public enum Course {
    BACKEND("백엔드"),
    FRONTEND("프론트엔드");

    private final String name;

    Course(final String name) {
        this.name = name;
    }

    public static Course from(final String name) {
        return Arrays.stream(values())
                .filter(response -> response.name.equalsIgnoreCase(name))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(ErrorMessage.INVALID_COURSE_INPUT.getMessage()));
    }
}
