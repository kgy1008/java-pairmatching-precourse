package pairmatching.domain.pair.generator;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Collections;
import java.util.List;

public class RandomSequenceGenerator implements SequenceGenerator {

    @Override
    public List<String> generate(final List<String> crews) {
        List<String> shuffledCrews = Randoms.shuffle(crews);
        return Collections.unmodifiableList(shuffledCrews);
    }
}
