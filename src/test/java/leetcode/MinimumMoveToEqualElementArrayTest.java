package leetcode;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author Tempo
 */
class MinimumMoveToEqualElementArrayTest {
    private final MinimumMoveToEqualElementArray solution = new MinimumMoveToEqualElementArray();

    @Test
    void minMoves2() {
        Assertions.assertThat(solution.minMoves2(new int[]{1, 10, 2, 9})).isEqualTo(16);
    }
}
