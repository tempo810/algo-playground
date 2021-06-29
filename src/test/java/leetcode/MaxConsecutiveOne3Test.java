package leetcode;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Tempo
 */
class MaxConsecutiveOne3Test {
    private final MaxConsecutiveOne3 solution = new MaxConsecutiveOne3();

    @Test
    void longestOnes() {
        assertThat(solution.longestOnes(new int[]{0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1}, 3)).isEqualTo(10);
    }
}
