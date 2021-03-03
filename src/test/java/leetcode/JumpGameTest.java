package leetcode;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;

/**
 * @author Tempo
 */
class JumpGameTest {
    private final JumpGame solution = new JumpGame();

    @Test
    void canJump() {
        assertThat(solution.canJump(new int[]{3, 2, 1, 0, 4}), Matchers.is(false));
        assertThat(solution.canJump(new int[]{1, 1, 1, 0}), Matchers.is(true));
    }
}
