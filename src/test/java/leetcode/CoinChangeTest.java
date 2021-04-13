package leetcode;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author tempo
 */
class CoinChangeTest {
    private final CoinChange solution = new CoinChange();

    @Test
    void coinChange() {
        assertThat(solution.coinChange(new int[]{186, 419, 83, 408}, 6249)).isEqualTo(20);
    }
}
