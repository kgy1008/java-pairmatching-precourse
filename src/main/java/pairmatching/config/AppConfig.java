package pairmatching.config;

import pairmatching.controller.PairController;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

public class AppConfig {
    
    public PairController controller() {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        return new PairController(inputView, outputView);
    }
}
