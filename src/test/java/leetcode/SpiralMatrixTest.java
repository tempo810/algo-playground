package leetcode;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Tempo
 */
class SpiralMatrixTest {
    private final SpiralMatrix solution = new SpiralMatrix();

    @Test
    void spiralOrder() {
        assertThat(solution.spiralOrder(new int[][]{{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10}, {11, 12, 13, 14, 15}, {16, 17, 18, 19, 20}, {21, 22, 23, 24, 25}})).containsExactly(1, 2, 3, 4, 5, 10, 15, 20, 25, 24, 23, 22, 21, 16, 11, 6, 7, 8, 9, 14, 19, 18, 17, 12, 13);
        assertThat(solution.spiralOrder(new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}})).containsExactly(1, 2, 3, 4, 8, 12, 11, 10, 9, 5, 6, 7);
        assertThat(solution.spiralOrder(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}})).containsExactly(1, 2, 3, 6, 9, 8, 7, 4, 5);
    }
}
