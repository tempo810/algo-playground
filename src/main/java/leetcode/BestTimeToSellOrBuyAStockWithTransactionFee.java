package leetcode;

/**
 * @author tempo
 */
public class BestTimeToSellOrBuyAStockWithTransactionFee {
    public int maxProfit(int[] prices, int fee) {
        int profit = 0;
        int endBuy = Integer.MIN_VALUE;

        for (int price : prices) {
            endBuy = Math.max(endBuy, profit - price - fee); // compete on minimum buying price
            profit = Math.max(profit, endBuy + price);
        }
        return profit;
    }
}
