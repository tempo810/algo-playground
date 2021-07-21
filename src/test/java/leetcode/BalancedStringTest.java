package leetcode;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Tempo
 */
class BalancedStringTest {
    private final BalancedString solution = new BalancedString();

    @Test
    void balanceString() {
        assertThat(solution.balanceString("WWEQERQWQWWRWWERQWEQ")).isEqualTo(4);
    }
}
