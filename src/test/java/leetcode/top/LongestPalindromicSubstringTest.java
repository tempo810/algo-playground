package leetcode.top;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author tempo
 */
class LongestPalindromicSubstringTest {
    private LongestPalindromicSubstring longestPalindromicSubstring;

    @BeforeEach
    void setUp() {
        this.longestPalindromicSubstring = new LongestPalindromicSubstring();
    }

    @Test
    void longestPalindrome() {
        Assertions.assertThat(this.longestPalindromicSubstring.longestPalindrome("ccc")).isEqualTo("ccc");
    }
}