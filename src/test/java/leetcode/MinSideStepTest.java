package leetcode;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Tempo
 */
class MinSideStepTest {
    private final MinSideStep solution = new MinSideStep();

    @Test
    void minSideJumps() {
        assertThat(solution.minSideJumps(new int[]{0, 1, 2, 3, 0})).isEqualTo(2);
    }
}
