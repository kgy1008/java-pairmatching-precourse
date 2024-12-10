package pairmatching.common;

public enum ErrorMessage {

    CAN_NOT_READ("파일을 읽을 수 없습니다"),

    INVALID_INPUT_TYPE("숫자로 입력해주세요."),
    INVALID_COURSE_INPUT("잘못된 과정 이름입니다."),
    INVALID_LEVEL_INPUT("잘못된 레벨 이름입니다."),
    INVALID_PAIR_SIZE("페어는 최소 2명에서 최대 3명이어야 합니다."),
    INVALID_MISSION_INPUT("잘못된 미션 이름입니다.");

    private static final String HEADER = "[ERROR] ";
    private final String message;

    ErrorMessage(final String message) {
        this.message = message;
    }

    public String getMessage() {
        return HEADER + message;
    }
}
