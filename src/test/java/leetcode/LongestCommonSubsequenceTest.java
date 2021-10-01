package leetcode;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Tempo
 */
class LongestCommonSubsequenceTest {
    private final LongestCommonSubsequence solution = new LongestCommonSubsequence();

    @Test
    void longestCommonSubsequence() {
        assertThat(solution.longestCommonSubsequence("abcde", "ace")).isEqualTo(3);
    }
}
