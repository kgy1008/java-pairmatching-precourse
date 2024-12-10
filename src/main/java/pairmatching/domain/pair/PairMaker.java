package pairmatching.domain.pair;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import pairmatching.common.ErrorMessage;
import pairmatching.config.Initializer;
import pairmatching.domain.crew.Crews;
import pairmatching.domain.curriculum.Course;
import pairmatching.domain.curriculum.Level;
import pairmatching.domain.curriculum.Mission;
import pairmatching.domain.pair.generator.SequenceGenerator;

public class PairMaker {

    private final Crews crews;
    private final SequenceGenerator sequenceGenerator;
    private final List<MatchResult> results;

    public PairMaker(final Initializer initializer, final SequenceGenerator sequenceGenerator) {
        this.crews = initializer.initialize();
        this.sequenceGenerator = sequenceGenerator;
        this.results = new ArrayList<>();
    }

    public boolean checkExistedPair(final Course course, final Level level, final Mission mission) {
        return results.stream()
                .anyMatch(matchResult -> matchResult.isExist(course, level, mission));
    }

    public Pairs generatePair(final Course course, final Level level, final Mission mission) {
        List<String> names = crews.findNameByCourse(course);
        List<String> shuffledNames = shuffle(names, level);
        if (shuffledNames.size() % 2 == 0) {
            Pairs pairs = new Pairs(makeEvenPair(shuffledNames, shuffledNames.size()));
            savePairResult(course, level, mission, pairs);
            return pairs;
        }
        Pairs pairs = new Pairs(makeOddPair(shuffledNames, shuffledNames.size() - 3));
        savePairResult(course, level, mission, pairs);
        return pairs;
    }

    private void savePairResult(final Course course, final Level level, final Mission mission, final Pairs pairs) {
        MatchResult matchResult = new MatchResult(course, level, mission, pairs);
        results.add(matchResult);
    }

    private List<Pair> makeEvenPair(final List<String> name, final int num) {
        List<Pair> pairs = new ArrayList<>();
        for (int i = 0; i < num; i += 2) {
            pairs.add(new Pair(name.get(i), name.get(i + 1)));
        }
        return pairs;
    }

    private List<Pair> makeOddPair(final List<String> name, final int num) {
        List<Pair> pairs = new ArrayList<>();
        for (int i = 0; i < num; i += 2) {
            pairs.add(new Pair(name.get(i), name.get(i + 1)));
        }
        pairs.add(new Pair(name.get(num), name.get(num + 1), name.get(num + 2)));
        return pairs;
    }

    private List<String> shuffle(final List<String> names, final Level level) {
        List<String> shuffledNames;
        do {
            shuffledNames = new ArrayList<>(sequenceGenerator.generate(names));
        } while (repeatShuffle(names, level));
        return shuffledNames;
    }

    private boolean repeatShuffle(final List<String> names, final Level level) {
        Optional<MatchResult> matchResult = findMatchedPairByLevel(level);
        return matchResult
                .map(result -> result.validateDuplicated(names))
                .orElse(false);
    }

    private Optional<MatchResult> findMatchedPairByLevel(final Level level) {
        return results.stream()
                .filter(result -> result.isExist(level))
                .findFirst();
    }

    public Pairs findPairs(final Course course, final Level level, final Mission mission) {
        return results.stream()
                .filter(matchResult -> matchResult.isExist(course, level, mission))
                .findFirst()
                .map(MatchResult::getPairs)
                .orElseThrow(() -> new IllegalArgumentException(ErrorMessage.NOT_FOUND_RESULT.getMessage()));
    }


    public void initPair() {
        results.removeAll(results);
    }
}
