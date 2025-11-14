package leetcode;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author tempo
 */
class FlipStringToMonotoneIncreaseTest {
    private final FlipStringToMonotoneIncrease solution = new FlipStringToMonotoneIncrease();

    @Test
    void minFlipsMonoIncr() {
        Assertions.assertThat(solution.minFlipsMonoIncr("00011000")).isEqualTo(2);
    }
}
