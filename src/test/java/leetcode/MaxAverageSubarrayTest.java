package leetcode;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author tempo
 */
class MaxAverageSubarrayTest {
    private final MaxAverageSubarray solution = new MaxAverageSubarray();

    @Test
    void findMaxAverage() {
        assertThat(solution.findMaxAverage(new int[]{1, 12, -5, -6, 50, 3}, 4)).isEqualTo(12.75);
        assertThat(solution.findMaxAverage(new int[]{0, 4, 0, 3, 2}, 1)).isEqualTo(4.0);
    }
}
