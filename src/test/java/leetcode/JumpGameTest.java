package leetcode;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Tempo
 */
class JumpGameTest {
    private final JumpGame solution = new JumpGame();

    @Test
    void canJump() {
        assertThat(solution.canJump(new int[]{3, 2, 1, 0, 4})).isFalse();
        assertThat(solution.canJump(new int[]{1, 1, 1, 0})).isTrue();
    }
}
