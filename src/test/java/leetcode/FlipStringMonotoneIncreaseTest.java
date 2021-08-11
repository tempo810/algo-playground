package leetcode;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Tempo
 */
class FlipStringMonotoneIncreaseTest {
    private final FlipStringMonotoneIncrease solution = new FlipStringMonotoneIncrease();

    @Test
    void minFlipsMonoIncr() {
        assertThat(solution.minFlipsMonoIncr("010110")).isEqualTo(2);
    }
}
