package leetcode;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * @author Tempo
 */
class GlobalAndLocalInversionTest {
    private final GlobalAndLocalInversion solution = new GlobalAndLocalInversion();

    @Test
    void isIdealPermutation() {
        assertThat(solution.isIdealPermutation(new int[]{0, 2, 1}), is(true));
        assertThat(solution.isIdealPermutation(new int[]{1, 0, 2}), is(true));
    }
}
