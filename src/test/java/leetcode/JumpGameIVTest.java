package leetcode;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author tempo
 */
class JumpGameIVTest {
    private final JumpGameIV solution = new JumpGameIV();

    @Test
    void minJumps() {
        Assertions.assertThat(solution.minJumps(new int[]{11, 22, 7, 7, 7, 7, 7, 7, 7, 22, 13})).isEqualTo(3);
    }
}
