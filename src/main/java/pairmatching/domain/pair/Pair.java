package pairmatching.domain.pair;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import pairmatching.common.ErrorMessage;

public class Pair {

    private static final int MIN_SIZE = 2;
    private static final int MAX_SIZE = 3;

    private final List<String> pair;

    public Pair(final String... pairName) {
        List<String> pairNames = List.of(pairName);
        validateSize(pairNames);
        this.pair = pairNames;
    }

    private void validateSize(final List<String> pair) {
        if (pair.size() < MIN_SIZE || pair.size() > MAX_SIZE) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_PAIR_SIZE.getMessage());
        }
    }

    public String getPairName() {
        return String.join(" : ", pair);
    }

    public List<String> getPair() {
        return Collections.unmodifiableList(pair);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Pair pair1 = (Pair) o;
        return Objects.equals(pair, pair1.pair);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(pair);
    }
}
