package leetcode;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Tempo
 */
class LargestDivisibleSubsetTest {
    private final LargestDivisibleSubset solution = new LargestDivisibleSubset();

    @Test
    void largestDivisibleSubset() {
        assertThat(solution.largestDivisibleSubset(new int[]{1, 2, 3})).containsExactly(1, 3);
    }
}
