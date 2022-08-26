package leetcode;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author tempo
 */
class ReorderedPowerOf2Test {
    private final ReorderedPowerOf2 solution = new ReorderedPowerOf2();

    @Test
    void reorderedPowerOf2() {
        Assertions.assertThat(solution.reorderedPowerOf2(1)).isTrue();
        Assertions.assertThat(solution.reorderedPowerOf2(10)).isFalse();
        Assertions.assertThat(solution.reorderedPowerOf2(46)).isTrue();
    }
}
