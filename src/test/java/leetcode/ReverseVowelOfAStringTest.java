package leetcode;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author tempo
 */
class ReverseVowelOfAStringTest {
    private ReverseVowelOfAString solution = new ReverseVowelOfAString();

    @Test
    void reverseVowels() {
        assertThat(solution.reverseVowels("a.")).isEqualTo("a.");
    }
}
