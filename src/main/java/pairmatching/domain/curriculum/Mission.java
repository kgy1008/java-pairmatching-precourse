package pairmatching.domain.curriculum;

import java.util.Arrays;
import pairmatching.common.ErrorMessage;

public enum Mission {
    RACING_CAR("자동차경주"),
    LOTTO("로또"),
    BASEBALL_GAME("숫자야구게임"),
    SHOPPING_CART("장바구니"),
    PAYMENT("결제"),
    SUBWAY("지하철노선도"),
    IMPROVEMENT("성능개선"),
    DEPLOY("배포"),
    NONE("");

    private final String name;

    Mission(final String name) {
        this.name = name;
    }

    public static Mission from(final String name) {
        return Arrays.stream(values())
                .filter(response -> response.name.equals(name))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(ErrorMessage.INVALID_MISSION_INPUT.getMessage()));
    }
}
