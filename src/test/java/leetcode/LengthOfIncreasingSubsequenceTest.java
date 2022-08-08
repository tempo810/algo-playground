package leetcode;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author tempo
 */
class LengthOfIncreasingSubsequenceTest {
    private final LengthOfIncreasingSubsequence solution = new LengthOfIncreasingSubsequence();

    @Test
    void lengthOfLIS() {
        assertThat(solution.lengthOfLIS(new int[]{10, 9, 2, 5, 3, 7, 101, 18})).isEqualTo(4);
    }
}
