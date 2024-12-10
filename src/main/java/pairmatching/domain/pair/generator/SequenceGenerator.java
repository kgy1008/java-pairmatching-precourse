package pairmatching.domain.pair.generator;

import java.util.List;

public interface SequenceGenerator {

    List<String> generate(final List<String> crews);
}
