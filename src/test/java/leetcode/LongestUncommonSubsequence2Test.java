package leetcode;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Tempo
 */
class LongestUncommonSubsequence2Test {
    private final LongestUncommonSubsequence2 solution = new LongestUncommonSubsequence2();

    @Test
    void findLUSlength() {
        assertThat(solution.findLUSlength(new String[]{"aaa", "aaa", "aa"})).isEqualTo(-1);
    }
}
