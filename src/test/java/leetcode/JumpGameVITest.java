package leetcode;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Tempo
 */
class JumpGameVITest {
    public final JumpGameVI solution = new JumpGameVI();

    @Test
    void maxResult() {
        assertThat(solution.maxResult(new int[]{1, -1, -2, 4, -7, 3}, 2)).isEqualTo(7);
        assertThat(solution.maxResultSlidingQueue(new int[]{1, -1, -2, 4, -7, 3}, 2)).isEqualTo(7);
    }
}
