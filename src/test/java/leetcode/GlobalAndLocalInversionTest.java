package leetcode;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Tempo
 */
class GlobalAndLocalInversionTest {
    private final GlobalAndLocalInversion solution = new GlobalAndLocalInversion();

    @Test
    void isIdealPermutation() {
        assertThat(solution.isIdealPermutation(new int[]{1, 0, 2})).isTrue();
    }
}
