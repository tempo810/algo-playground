package leetcode;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Tempo
 */
class SubstringWithConcatenationOfAllWordsTest {
    private final SubstringWithConcatenationOfAllWords solution = new SubstringWithConcatenationOfAllWords();

    @Test
    void findSubstring() {
        assertThat(solution.findSubstring("barfoothefoobarman", new String[]{"foo", "bar"})).containsExactlyInAnyOrder(0, 9);
    }
}
