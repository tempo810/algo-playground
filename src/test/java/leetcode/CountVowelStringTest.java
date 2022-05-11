package leetcode;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Tempo
 */
class CountVowelStringTest {
    private final CountVowelString solution = new CountVowelString();

    @Test
    void countVowelStrings() {
        assertThat(solution.countVowelStrings(33)).isEqualTo(66045);
        assertThat(solution.countVowelStringDp(33)).isEqualTo(66045);
    }
}
