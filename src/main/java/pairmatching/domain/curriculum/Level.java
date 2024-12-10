package pairmatching.domain.curriculum;

import java.util.Arrays;
import java.util.List;
import pairmatching.common.ErrorMessage;

public enum Level {
    LEVEL1("레벨1", Mission.RACING_CAR, Mission.LOTTO, Mission.BASEBALL_GAME),
    LEVEL2("레벨2", Mission.SHOPPING_CART, Mission.PAYMENT, Mission.SUBWAY),
    LEVEL3("레벨3", Mission.NONE),
    LEVEL4("레벨4", Mission.PAYMENT, Mission.DEPLOY),
    LEVEL5("레벨5", Mission.NONE);

    private final String name;
    private final List<Mission> missions;

    Level(final String name, final Mission... missions) {
        this.name = name;
        this.missions = Arrays.asList(missions);
    }

    public static Level from(final String name) {
        return Arrays.stream(values())
                .filter(response -> response.name.equals(name))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(ErrorMessage.INVALID_LEVEL_INPUT.getMessage()));
    }
}
