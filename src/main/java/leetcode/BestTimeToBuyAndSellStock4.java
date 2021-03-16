package leetcode;

/**
 * @author Tempo
 */
public class BestTimeToBuyAndSellStock4 {
    public int maxProfit(int k, int[] prices) {
        int[][] dp = new int[k + 1][2]; // dp[0] = withStock, dp[1] = noStock
        for (int[] d : dp) {
            d[0] = Integer.MIN_VALUE;
        }

        for (int price : prices) {
            for (int i = 1; i <= k; i++) {
                dp[i][0] = Math.max(dp[i][0], dp[i - 1][1] - price);
                dp[i][1] = Math.max(dp[i][1], dp[i][0] + price);
            }
        }

        return dp[k][1];
    }
}
