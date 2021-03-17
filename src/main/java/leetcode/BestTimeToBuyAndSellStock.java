package leetcode;

/**
 * @author tempo
 */
public class BestTimeToBuyAndSellStock {
    public int maxProfit(int[] prices) {
        int max = 0;
        int currentMax = 0;
        for (int i = 1; i < prices.length; i++) {
            currentMax = Math.max(0, currentMax + prices[i] - prices[i - 1]);
            max = Math.max(max, currentMax);
        }
        return max;
    }

    public int maxProfitPrefixSumApproach(int[] prices) {
        int buy = Integer.MIN_VALUE;
        int sell = 0;

        for (int price : prices) {
            buy = Math.max(buy, -price);
            sell = Math.max(sell, buy + price);
        }

        return sell;
    }
}
