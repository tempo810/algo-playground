package leetcode;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author tempo
 */
class SimilarStringGroupTest {
    private final SimilarStringGroup solution = new SimilarStringGroup();

    @Test
    void numSimilarGroups() {
        Assertions.assertThat(solution.numSimilarGroups(new String[]{"jvhpg", "jhvpg", "hpvgj", "hvpgj", "vhgjp"})).isEqualTo(3);
    }
}
