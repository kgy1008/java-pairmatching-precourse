package pairmatching.domain.command;

import java.util.Arrays;
import java.util.List;
import pairmatching.common.ErrorMessage;

public enum FeatureCommand {

    ONE("1", "페어 매칭"),
    TWO("2", "페어 조회"),
    THREE("3", "페어 초기화"),
    QUIT("Q", "종료");

    private final String description;
    private final String name;

    FeatureCommand(final String description, final String name) {
        this.description = description;
        this.name = name;
    }

    public static FeatureCommand from(final String description) {
        return Arrays.stream(values())
                .filter(response -> response.description.equalsIgnoreCase(description))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(ErrorMessage.INVALID_FEATURE_INPUT.getMessage()));
    }

    public static List<FeatureCommand> getAllCommands() {
        return Arrays.asList(FeatureCommand.values());
    }

    public String getDescription() {
        return description;
    }

    public String getName() {
        return name;
    }
}
