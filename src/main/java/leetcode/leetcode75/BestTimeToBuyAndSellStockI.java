package leetcode.leetcode75;

/**
 * @author tempo
 */
public class BestTimeToBuyAndSellStockI {
    public int maxProfit(int[] prices) {
        int currentBuy = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int price : prices) {
            currentBuy = Math.min(currentBuy, price);
            maxProfit = Math.max(maxProfit, price - currentBuy);
        }
        return maxProfit;
    }
}
