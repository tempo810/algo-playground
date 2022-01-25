package leetcode;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Tempo
 */
class ValidMountainArrayTest {
    private final ValidMountainArray solution = new ValidMountainArray();

    @Test
    void validMountainArray() {
        assertThat(solution.validMountainArray(new int[]{0, 3, 2, 1})).isEqualTo(true);
    }
}
