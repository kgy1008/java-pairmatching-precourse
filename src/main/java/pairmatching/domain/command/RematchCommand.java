package pairmatching.domain.command;

import java.util.Arrays;
import pairmatching.common.ErrorMessage;

public enum RematchCommand {

    YES("네"),
    NO("아니오");

    private final String description;

    RematchCommand(final String description) {
        this.description = description;
    }

    public static RematchCommand from(final String description) {
        return Arrays.stream(values())
                .filter(response -> response.description.equals(description))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(ErrorMessage.INVALID_REMATCH_INPUT.getMessage()));
    }
}
