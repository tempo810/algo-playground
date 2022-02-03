package leetcode;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Tempo
 */
class FourSum2Test {
    private final FourSum2 solution = new FourSum2();

    @Test
    void fourSumCount() {
        assertThat(solution.fourSumCount(new int[]{1, 2}, new int[]{-2, -1}, new int[]{-1, 2}, new int[]{0, 2})).isEqualTo(2);
    }
}
