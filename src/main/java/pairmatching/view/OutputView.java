package pairmatching.view;

import pairmatching.domain.curriculum.Level;

public class OutputView {

    public void printCourseInfo() {
        System.out.println("#############################################");
        System.out.println("과정: 백엔드 | 프론트엔드");
        System.out.println("미션:");
        Level.getAllCommands()
                .forEach(level -> System.out.printf("- %s: %s%n", level.getName(), level.getMissions()));
        System.out.println("###############################################");
    }

    public void printErrorMessage(final String message) {
        System.out.println(message);
    }
}
