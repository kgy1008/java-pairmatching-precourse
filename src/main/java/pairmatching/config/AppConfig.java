package pairmatching.config;

import pairmatching.controller.PairController;
import pairmatching.domain.pair.PairMaker;
import pairmatching.domain.pair.generator.RandomSequenceGenerator;
import pairmatching.provider.CrewFileReader;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

public class AppConfig {

    public PairController controller() {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        return new PairController(inputView, outputView, pairMaker());
    }

    private PairMaker pairMaker() {
        return new PairMaker(initializer(), new RandomSequenceGenerator());
    }

    private Initializer initializer() {
        return new Initializer(new CrewFileReader());
    }
}
