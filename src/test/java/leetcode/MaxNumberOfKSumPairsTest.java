package leetcode;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Tempo
 */
class MaxNumberOfKSumPairsTest {
    private final MaxNumberOfKSumPairs solution = new MaxNumberOfKSumPairs();

    @Test
    void maxOperations() {
        assertThat(solution.maxOperations(new int[]{1, 2, 3, 4}, 5)).isEqualTo(2);
        assertThat(solution.maxOperations(new int[]{3, 1, 3, 4, 3}, 6)).isEqualTo(1);
    }
}
