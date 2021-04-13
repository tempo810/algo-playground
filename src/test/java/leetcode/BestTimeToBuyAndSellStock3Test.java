package leetcode;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Tempo
 */
class BestTimeToBuyAndSellStock3Test {
    private final BestTimeToBuyAndSellStock3 solution = new BestTimeToBuyAndSellStock3();

    @Test
    void test() {
        assertThat(solution.maxProfit(new int[]{3, 3, 5, 0, 0, 3, 1, 4})).isEqualTo(6);
    }
}
