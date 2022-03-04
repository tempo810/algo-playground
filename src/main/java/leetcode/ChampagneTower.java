package leetcode;

/**
 * @author Tempo
 */
public class ChampagneTower {
    public double champagneTower(int poured, int query_row, int query_glass) {
        double[][] dp = new double[query_row + 1][query_glass + 2];
        dp[0][0] = poured;
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j <= query_glass; j++) {
                double remaining = Math.max(dp[i][j] - 1, 0) / 2;
                dp[i + 1][j] += remaining;
                dp[i + 1][j + 1] += remaining;
            }
        }
        return Math.min(1, dp[query_row][query_glass]);
    }
}
