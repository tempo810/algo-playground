package leetcode;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Tempo
 */
class MaxTurbulentSubarrayTest {
    private final MaxTurbulentSubarray solution = new MaxTurbulentSubarray();

    @Test
    void maxTurbulenceSize() {
        assertThat(solution.maxTurbulenceSize(new int[]{9, 4, 2, 10, 7, 8, 8, 1, 9})).isEqualTo(5);
        assertThat(solution.maxTurbulenceSize(new int[]{4, 8, 12, 16})).isEqualTo(2);
        assertThat(solution.maxTurbulenceSize(new int[]{100})).isEqualTo(1);
        assertThat(solution.maxTurbulenceSize(new int[]{9, 9})).isEqualTo(1);
    }
}
