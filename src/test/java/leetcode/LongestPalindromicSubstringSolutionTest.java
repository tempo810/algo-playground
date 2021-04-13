package leetcode;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Tempo
 */
class LongestPalindromicSubstringSolutionTest {
    private final LongestPalindromicSubstringSolution solution = new LongestPalindromicSubstringSolution();

    @Test
    void longestPalindrome() {
        assertThat(solution.longestPalindrome("babad")).isIn("bab", "aba");
        assertThat(solution.longestPalindrome("cbbd")).isEqualTo("bb");
        assertThat(solution.longestPalindrome("a")).isEqualTo("a");
        assertThat(solution.longestPalindrome("ac")).isIn("a", "c");
    }
}
