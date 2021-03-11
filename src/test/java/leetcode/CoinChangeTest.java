package leetcode;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;

/**
 * @author tempo
 */
class CoinChangeTest {
    private final CoinChange solution = new CoinChange();

    @Test
    void coinChange() {
        assertThat(solution.coinChange(new int[]{186, 419, 83, 408}, 6249), Matchers.is(20));
    }
}
