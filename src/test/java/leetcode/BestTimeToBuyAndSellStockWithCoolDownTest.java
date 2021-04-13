package leetcode;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


/**
 * @author Tempo
 */
class BestTimeToBuyAndSellStockWithCoolDownTest {
    private final BestTimeToBuyAndSellStockWithCoolDown solution = new BestTimeToBuyAndSellStockWithCoolDown();

    @Test
    void maxProfit() {
        assertThat(solution.maxProfit(new int[]{1, 2, 3, 0, 2})).isEqualTo(3);
    }
}
