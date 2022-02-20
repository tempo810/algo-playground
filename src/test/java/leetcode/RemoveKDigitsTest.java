package leetcode;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Tempo
 */
class RemoveKDigitsTest {
    private final RemoveKDigits solution = new RemoveKDigits();

    @Test
    void removeKdigits() {
        assertThat(solution.removeKdigits("1432219", 3)).isEqualTo("1219");
    }
}
