package leetcode;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * @author Tempo
 */
class BestTimeToBuyAndSellStockWithCoolDownTest {
    private final BestTimeToBuyAndSellStockWithCoolDown solution = new BestTimeToBuyAndSellStockWithCoolDown();

    @Test
    void maxProfit() {
        assertThat(solution.maxProfit(new int[]{1, 2, 3, 0, 2}), is(3));
    }
}
