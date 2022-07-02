package leetcode;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author Tempo
 */
class MaximumAreaOfAPieceOfCakeAfterHorizontalAndVerticalCutsTest {
    private final MaximumAreaOfAPieceOfCakeAfterHorizontalAndVerticalCuts solution = new MaximumAreaOfAPieceOfCakeAfterHorizontalAndVerticalCuts();

    @Test
    void maxArea() {
        Assertions.assertThat(solution.maxArea(1000000000, 1000000000, new int[]{2}, new int[]{2})).isEqualTo(81);

    }
}
