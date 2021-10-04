package leetcode;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Tempo
 */
class MinimumPathSumTest {
    private final MinimumPathSum solution = new MinimumPathSum();

    @Test
    void minPathSum() {
        assertThat(solution.minPathSum(new int[][]{{1, 2, 3}, {4, 5, 6}})).isEqualTo(12);
    }
}
