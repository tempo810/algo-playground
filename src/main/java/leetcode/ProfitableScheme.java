package leetcode;

/**
 * @author tempo
 */
public class ProfitableScheme {
    public int profitableSchemes(int n, int minProfit, int[] group, int[] profit) {
        long[][][] dp = new long[n + 1][minProfit + 1][group.length];
        int result = (int) find(n, 0, minProfit, group, profit, dp);
        return result == -1 ? 0 : result;
    }

    private long find(int n, int index, int remainingProfit, int[] group, int[] profit, long[][][] dp) {
        if (n < 0 || (n == 0 && remainingProfit > 0)) {
            return -1;
        }

        if (index == group.length) {
            return remainingProfit <= 0 ? 1 : -1;
        }

        if (dp[n][remainingProfit][index] == 0) {
            dp[n][remainingProfit][index] = find(n, index + 1, remainingProfit, group, profit, dp);
            long noPass = find(n - group[index], index + 1, Math.max(remainingProfit - profit[index], 0), group, profit, dp);
            if (noPass != -1) {
                dp[n][remainingProfit][index] = (int) ((long) (Math.max(0, dp[n][remainingProfit][index]) + noPass) % (long) (1e9 + 7));
            }
        }
        return dp[n][remainingProfit][index];
    }
}
