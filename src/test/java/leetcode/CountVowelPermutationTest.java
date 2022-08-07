package leetcode;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author tempo
 */
class CountVowelPermutationTest {
    private final CountVowelPermutation solution = new CountVowelPermutation();

    @Test
    void countVowelPermutation() {
        assertThat(solution.countVowelPermutation(5)).isEqualTo(68);
    }
}
