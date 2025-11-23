package leetcode.leetcode75;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author tempo
 */
class LongestCommonSubsequenceTest {
    private LongestCommonSubsequence longestCommonSubsequence;

    @BeforeEach
    void setUp() {
        this.longestCommonSubsequence = new LongestCommonSubsequence();
    }

    @Test
    void longestCommonSubsequenceBottomUp() {
        Assertions.assertThat(this.longestCommonSubsequence.longestCommonSubsequenceBottomUp("abcde", "ace")).isEqualTo(3);
    }
}