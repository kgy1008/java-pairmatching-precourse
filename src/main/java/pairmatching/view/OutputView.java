package pairmatching.view;

import pairmatching.domain.curriculum.Level;
import pairmatching.domain.pair.Pairs;

public class OutputView {

    public void printCourseInfo() {
        System.out.println();
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

    public void printPairs(final Pairs pairs) {
        System.out.println("페어 매칭 결과입니다.");
        pairs.getPairs().forEach(pair -> System.out.printf("%s%n", pair.getPairName()));
    }
}
