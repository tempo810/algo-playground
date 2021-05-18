package leetcode;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Tempo
 */
class LongestStringChainTest {
    private final LongestStringChain solution = new LongestStringChain();

    @Test
    void longestStrChain() {
        assertThat(solution.longestStrChain(new String[]{"a", "b", "ba", "abc", "abd", "bdca"})).isEqualTo(2);
    }
}
