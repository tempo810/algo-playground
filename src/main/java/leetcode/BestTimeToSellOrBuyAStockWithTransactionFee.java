package leetcode;

/**
 * @author tempo
 */
public class BestTimeToSellOrBuyAStockWithTransactionFee {
    public int maxProfitDp(int[] prices, int fee) {
        int[][] dp = new int[prices.length - 1][2];
        dp[0][0] = (prices[0] + fee) * -1; // buy
        dp[0][1] = 0; // sell

        for (int i = 1; i < prices.length; i++) {
            int[] prev = dp[i - 1];
            dp[i][0] = Math.max(prev[0], prev[1] - prices[i] - fee);
            dp[i][1] = Math.max(prev[1], prev[0] + prices[i]);
        }
        return Math.max(dp[prices.length - 1][0], dp[prices.length - 1][1]);
    }

    public int maxProfit(int[] prices, int fee) {
        int noStock = 0;
        int haveStock = Integer.MIN_VALUE;

        for (int price : prices) {
            haveStock = Math.max(haveStock, noStock - price - fee); // compete on minimum buying price
            noStock = Math.max(noStock, haveStock + price);
        }
        return noStock;
    }
}
