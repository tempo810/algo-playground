package leetcode;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Tempo
 */
class ReverseWordInAStringTest {
    private final ReverseWordsInAString solution = new ReverseWordsInAString();

    @Test
    void reverseWords() {
        assertThat(solution.reverseWords("the sky is blue")).isEqualTo("blue is sky the");
        assertThat(solution.reverseWords(" hello world  ")).isEqualTo("world hello");
        assertThat(solution.reverseWords("a good   example")).isEqualTo("example good a");
    }
}
