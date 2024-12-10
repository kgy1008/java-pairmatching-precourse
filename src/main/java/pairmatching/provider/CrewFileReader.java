package pairmatching.provider;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import pairmatching.common.ErrorMessage;
import pairmatching.domain.crew.Crew;
import pairmatching.domain.curriculum.Course;

public class CrewFileReader {

    private static final String BACKEND_CREW_INFO_FILE_PATH = "src/main/resources/backend-crew.md";
    private static final String FRONTEND_CREW_INFO_FILE_PATH = "src/main/resources/frontend-crew.md";

    public List<Crew> getBackendCrews() {
        try {
            List<String> lines = Files.readAllLines(Paths.get(BACKEND_CREW_INFO_FILE_PATH));
            return readFileLines(lines, Course.BACKEND);
        } catch (IOException e) {
            throw new IllegalArgumentException(ErrorMessage.CAN_NOT_READ.getMessage(), e);
        }
    }

    public List<Crew> getFrontendCrews() {
        try {
            List<String> lines = Files.readAllLines(Paths.get(FRONTEND_CREW_INFO_FILE_PATH));
            return readFileLines(lines, Course.FRONTEND);
        } catch (IOException e) {
            throw new IllegalArgumentException(ErrorMessage.CAN_NOT_READ.getMessage(), e);
        }
    }

    private List<Crew> readFileLines(final List<String> lines, final Course course) {
        return lines.stream()
                .map(line -> new Crew(line, course))
                .toList();
    }
}
