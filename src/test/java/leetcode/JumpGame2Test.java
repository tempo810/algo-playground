package leetcode;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * @author tempo
 */
class JumpGame2Test {
    private final JumpGame2 solution = new JumpGame2();

    @Test
    void jump() {
        assertThat(solution.jump(new int[]{1, 1, 2, 1, 1}), is(3));
        assertThat(solution.jump(new int[]{2, 3, 1, 1, 4}), is(2));
        assertThat(solution.jump(new int[]{2, 1}), is(1));
    }
}
