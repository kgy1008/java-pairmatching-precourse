package pairmatching.domain.pair;

import java.util.Collections;
import java.util.List;
import java.util.Set;

public class Pairs {

    private final List<Pair> pairs;

    public Pairs(final List<Pair> pairs) {
        this.pairs = pairs;
    }

    boolean checkDuplicated(final Set<String> target) {
        return pairs.stream()
                .anyMatch(pair -> pair.getPair().equals(target));
    }

    public List<Pair> getPairs() {
        return Collections.unmodifiableList(pairs);
    }
}
