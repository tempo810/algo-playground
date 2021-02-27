package leetcode;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.oneOf;

/**
 * @author Tempo
 */
class LongestPalindromicSubstringSolutionTest {
    private final LongestPalindromicSubstringSolution solution = new LongestPalindromicSubstringSolution();

    @Test
    void longestPalindrome() {
        assertThat(solution.longestPalindrome("babad"), oneOf("bab", "aba"));
        assertThat(solution.longestPalindrome("cbbd"), is("bb"));
        assertThat(solution.longestPalindrome("a"), is("a"));
        assertThat(solution.longestPalindrome("ac"), oneOf("a", "c"));
    }
}
