package leetcode;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author tempo
 */
class ThreeSumWithMultiplicityTest {
    private final ThreeSumWithMultiplicity solution = new ThreeSumWithMultiplicity();

    @Test
    void threeSumMulti() {
        assertThat(solution.threeSumMultiV2(new int[]{1, 1, 2, 2, 2, 2}, 5)).isEqualTo(12);
    }
}
