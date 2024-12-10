package pairmatching.controller;

import java.util.function.Supplier;
import pairmatching.service.MatchService;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

public class PairController {

    private final InputView inputView;
    private final OutputView outputView;
    private final MatchService matchService;

    public PairController(final InputView inputView, final OutputView outputView, final MatchService matchService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.matchService = matchService;
    }

    public void run() {

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

    private void rerunTemplate(final Runnable action) {
        while (true) {
            try {
                action.run();
                break;
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e.getMessage());
            }
        }
    }
}
