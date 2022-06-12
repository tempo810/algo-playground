package leetcode;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Tempo
 */
class MaximumErasureValueTest {
    private final MaximumErasureValue solution = new MaximumErasureValue();

    @Test
    void maximumUniqueSubarrayV3() {
        assertThat(solution.maximumUniqueSubarrayV3(new int[]{4, 2, 4, 5, 6})).isEqualTo(17);
    }
}
