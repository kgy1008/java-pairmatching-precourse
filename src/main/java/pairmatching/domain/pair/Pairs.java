package pairmatching.domain.pair;

import java.util.Collections;
import java.util.List;

public class Pairs {

    private final List<Pair> pairs;

    public Pairs(final List<Pair> pairs) {
        this.pairs = pairs;
    }

    boolean checkDuplicated(final List<String> target) {
        return pairs.stream()
                .anyMatch(pair -> pair.getPair().equals(target));
    }

    public List<Pair> getPairs() {
        return Collections.unmodifiableList(pairs);
    }
}
