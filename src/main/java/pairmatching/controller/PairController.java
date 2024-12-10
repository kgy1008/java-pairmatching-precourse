package pairmatching.controller;

import java.util.function.Supplier;
import pairmatching.domain.command.FeatureCommand;
import pairmatching.domain.command.RematchCommand;
import pairmatching.domain.curriculum.Course;
import pairmatching.domain.curriculum.Level;
import pairmatching.domain.curriculum.Mission;
import pairmatching.domain.pair.PairMaker;
import pairmatching.domain.pair.Pairs;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

public class PairController {

    private final InputView inputView;
    private final OutputView outputView;
    private final PairMaker pairMaker;

    public PairController(final InputView inputView, final OutputView outputView, final PairMaker pairMaker) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.pairMaker = pairMaker;
    }

    public void run() {
        FeatureCommand command = play();
        while (command != FeatureCommand.QUIT) {
            command = play();
        }
    }

    private FeatureCommand play() {
        return rerunTemplate(() -> {
            FeatureCommand command = enterFeatureCommand();
            startFeature(command);
            return command;
        });
    }

    private FeatureCommand enterFeatureCommand() {
        return rerunTemplate(inputView::inputFeature);
    }

    private void startFeature(final FeatureCommand featureCommand) {
        if (featureCommand == FeatureCommand.ONE) {
            outputView.printCourseInfo();
            String command = rerunTemplate(inputView::inputDetail);
            Pairs pairs = makePair(parseCourse(command), parseLevel(command), parseMission(command));
            outputView.printPairs(pairs);
        }
        if (featureCommand == FeatureCommand.TWO) {
            outputView.printCourseInfo();
            String command = rerunTemplate(inputView::inputDetail);
            Pairs pairs = pairMaker.findPairs(parseCourse(command), parseLevel(command), parseMission(command));
            outputView.printPairs(pairs);
        }
        if (featureCommand == FeatureCommand.THREE) {
            pairMaker.initPair();
        }
    }

    private Pairs makePair(final Course course, final Level level, final Mission mission) {
        if (pairMaker.checkExistedPair(course, level, mission)) {
            RematchCommand command = rerunTemplate(inputView::inputRematch);
            if (command == RematchCommand.YES) {
                return pairMaker.generatePair(course, level, mission);
            }
        }
        return pairMaker.generatePair(course, level, mission);
    }

    private Course parseCourse(String command) {
        String[] commandParts = command.split(",");
        return Course.from(commandParts[0].trim());
    }

    private Level parseLevel(String command) {
        String[] commandParts = command.split(",");
        return Level.from(commandParts[1].trim());
    }

    private Mission parseMission(String command) {
        String[] commandParts = command.split(",");
        return Mission.from(commandParts[2].trim());
    }

    private <T> T rerunTemplate(final Supplier<T> action) {
        while (true) {
            try {
                return action.get();
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e.getMessage());
            }
        }
    }
}
