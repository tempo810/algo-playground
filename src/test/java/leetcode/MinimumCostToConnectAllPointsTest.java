package leetcode;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Tempo
 */
class MinimumCostToConnectAllPointsTest {
    private final MinimumCostToConnectAllPoints solution = new MinimumCostToConnectAllPoints();

    @Test
    void minCostConnectPoints() {
        assertThat(solution.minCostConnectPoints(new int[][]{{0, 0}, {2, 2}, {3, 10}, {5, 2}, {7, 0}})).isEqualTo(20);
    }
}
