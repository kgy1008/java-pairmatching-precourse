package pairmatching.service;

import pairmatching.config.Initializer;
import pairmatching.domain.crew.Crews;

public class MatchService {

    private final Crews crews;

    public MatchService(final Initializer initializer) {
        this.crews = initializer.initialize();
    }
}
