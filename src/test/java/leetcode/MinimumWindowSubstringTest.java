package leetcode;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Tempo
 */
class MinimumWindowSubstringTest {
    private final MinimumWindowSubstring solution = new MinimumWindowSubstring();

    @Test
    void minWindow() {
        assertThat(solution.minWindow("ADOBECODEBANC", "ABC")).isEqualTo("BANC");
    }
}
