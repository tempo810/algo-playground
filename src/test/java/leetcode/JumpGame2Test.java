package leetcode;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author tempo
 */
class JumpGame2Test {
    private final JumpGame2 solution = new JumpGame2();

    @Test
    void jump() {
        assertThat(solution.jump(new int[]{1, 1, 2, 1, 1})).isEqualTo(3);
        assertThat(solution.jump(new int[]{2, 3, 1, 1, 4})).isEqualTo(2);
        assertThat(solution.jump(new int[]{2, 1})).isEqualTo(1);
    }
}
