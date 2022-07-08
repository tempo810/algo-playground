package leetcode;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Tempo
 */
class PaintHouse3Test {
    private final PaintHouse3 solution = new PaintHouse3();

    @Test
    void minCost() {
        int[] houses = new int[]{0, 0, 0, 0, 0};
        int[][] costs = new int[][]{{1, 10}, {10, 1}, {10, 1}, {1, 10}, {5, 1}};

        assertThat(solution.minCost(houses, costs, 5, 2, 3)).isEqualTo(9);
    }
}
