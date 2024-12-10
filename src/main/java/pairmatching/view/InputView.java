package pairmatching.view;

import camp.nextstep.edu.missionutils.Console;
import pairmatching.domain.command.FeatureCommand;
import pairmatching.domain.command.RematchCommand;
import pairmatching.domain.curriculum.Course;
import pairmatching.domain.curriculum.Level;
import pairmatching.domain.curriculum.Mission;

public class InputView {

    public FeatureCommand inputFeature() {
        System.out.println("기능을 선택하세요.");
        FeatureCommand.getAllCommands()
                .forEach(command -> System.out.printf("%s. %s%n", command.getDescription(), command.getName()));
        String command = Console.readLine();
        return FeatureCommand.from(command);
    }

    public String inputDetail() {
        System.out.println("과정, 레벨, 미션을 선택하세요.");
        System.out.println("ex) 백엔드, 레벨1, 자동차경주");
        String command = Console.readLine();
        validateCommand(command);
        return command;
    }

    public RematchCommand inputRematch() {
        System.out.println("매칭 정보가 있습니다. 다시 매칭하시겠습니까?");
        System.out.println("네 | 아니오");
        String command = Console.readLine();
        return RematchCommand.from(command);
    }

    private void validateCommand(final String command) {
        String[] commandParts = command.split(",");
        Course.from(commandParts[0].trim());
        Level.from(commandParts[1].trim());
        Mission.from(commandParts[2].trim());
    }
}
