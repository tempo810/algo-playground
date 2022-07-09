package leetcode;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author Tempo
 */
class JumpGameVIITest {
    private final JumpGameVII solution = new JumpGameVII();

    @Test
    void canReach() {
        Assertions.assertThat(solution.canReach("01101110", 2, 3)).isFalse();
        Assertions.assertThat(solution.canReach("011010", 2, 3)).isTrue();
    }
}
