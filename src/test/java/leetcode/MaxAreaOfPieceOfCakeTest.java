package leetcode;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Tempo
 */
class MaxAreaOfPieceOfCakeTest {
    private final MaxAreaOfPieceOfCake solution = new MaxAreaOfPieceOfCake();

    @Test
    void maxArea() {
        assertThat(solution.maxArea(50, 15, new int[]{37, 40, 41, 30, 27, 10, 31}, new int[]{2, 1, 9, 5, 4, 12, 6, 13, 11})).isEqualTo(51);
    }
}
