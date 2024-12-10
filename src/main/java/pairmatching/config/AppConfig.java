package pairmatching.config;

import pairmatching.controller.PairController;
import pairmatching.provider.CrewFileReader;
import pairmatching.service.MatchService;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

public class AppConfig {

    public PairController controller() {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        return new PairController(inputView, outputView, matchService());
    }

    private MatchService matchService() {
        return new MatchService(initializer());
    }

    private Initializer initializer() {
        return new Initializer(new CrewFileReader());
    }
}
