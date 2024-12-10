package pairmatching.view;

import camp.nextstep.edu.missionutils.Console;
import pairmatching.domain.command.FeatureCommand;

public class InputView {

    public FeatureCommand inputFeature() {
        System.out.println("기능을 선택하세요.");
        FeatureCommand.getAllCommands()
                .forEach(command -> System.out.printf("%s. %s%n", command.getDescription(), command.getName()));
        String command = Console.readLine();
        return FeatureCommand.from(command);
    }

    public String inputDetail() {
        return Console.readLine();
    }
}
