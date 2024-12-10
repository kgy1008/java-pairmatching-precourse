package pairmatching.domain.curriculum;

import java.util.Arrays;
import java.util.List;
import pairmatching.common.ErrorMessage;

public enum Level {
    LEVEL1("레벨1", "자동차경주", "로또", "숫자야구게임"),
    LEVEL2("레벨2", "장바구니", "결제", "지하철노선도"),
    LEVEL3("레벨3", ""),
    LEVEL4("레벨4", "성능개선", "배포"),
    LEVEL5("레벨5", "");

    private final String name;
    private final List<String> missions;

    Level(final String name, final String... missions) {
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
