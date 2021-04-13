package leetcode;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author tempo
 */
class LongestSubstringWithoutRepeatingCharacterTest {
    private final LongestSubstringWithoutRepeatingCharacter solution = new LongestSubstringWithoutRepeatingCharacter();

    @Test
    void lengthOfLongestSubstring() {
        assertThat(solution.lengthOfLongestSubstring("abba")).isEqualTo(2);
        assertThat(solution.lengthOfLongestSubstring("abcabcbb")).isEqualTo(3);
    }
}
