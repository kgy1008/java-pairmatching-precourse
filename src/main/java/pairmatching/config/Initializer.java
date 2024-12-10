package pairmatching.config;

import java.util.ArrayList;
import java.util.List;
import pairmatching.domain.crew.Crew;
import pairmatching.domain.crew.Crews;
import pairmatching.provider.CrewFileReader;

public class Initializer {

    private final CrewFileReader crewFileReader;

    public Initializer(final CrewFileReader crewFileReader) {
        this.crewFileReader = crewFileReader;
    }

    public Crews initialize() {
        List<Crew> crews = new ArrayList<>();
        crews.addAll(crewFileReader.getBackendCrews());
        crews.addAll(crewFileReader.getFrontendCrews());
        return new Crews(crews);
    }
}
