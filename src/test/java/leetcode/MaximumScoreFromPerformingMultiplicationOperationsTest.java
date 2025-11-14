package leetcode;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author tempo
 */
class MaximumScoreFromPerformingMultiplicationOperationsTest {
    private final MaximumScoreFromPerformingMultiplicationOperations solution = new MaximumScoreFromPerformingMultiplicationOperations();

    @Test
    void maximumScore() {
        assertThat(solution.maximumScore(new int[]{1, 2, 3}, new int[]{3, 2, 1})).isEqualTo(14);
    }
}
