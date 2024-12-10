package pairmatching.domain.curriculum;

import java.util.Arrays;
import pairmatching.common.ErrorMessage;

public enum Level {
    LEVEL1("레벨1"),
    LEVEL2("레벨2"),
    LEVEL3("레벨3"),
    LEVEL4("레벨4"),
    LEVEL5("레벨5");

    private final String name;

    Level(final String name) {
        this.name = name;
    }

    public static Level from(final String name) {
        return Arrays.stream(values())
                .filter(response -> response.name.equals(name))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(ErrorMessage.INVALID_LEVEL_INPUT.getMessage()));
    }
}
