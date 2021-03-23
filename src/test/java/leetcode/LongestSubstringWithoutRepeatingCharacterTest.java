package leetcode;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;

/**
 * @author tempo
 */
class LongestSubstringWithoutRepeatingCharacterTest {
    private final LongestSubstringWithoutRepeatingCharacter solution = new LongestSubstringWithoutRepeatingCharacter();

    @Test
    void lengthOfLongestSubstring() {
        assertThat(solution.lengthOfLongestSubstring("abba"), Matchers.is(2));
        assertThat(solution.lengthOfLongestSubstring("abcabcbb"), Matchers.is(3));
    }
}
