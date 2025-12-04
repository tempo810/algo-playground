package leetcode.top;

import java.util.Arrays;

/**
 * @author tempo
 */
public class UniquePath {

    private final int[][] directions = new int[][]{{1, 0}, {0, 1}};

    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for (int[] arr : dp) {
            Arrays.fill(arr, -1);
        }
        dp[m - 1][n - 1] = 1;
        return this.dfs(0, 0, dp);
    }

    private int dfs(int n, int m, int[][] dp) {
        if (n == dp.length || m == dp[0].length) {
            return 0;
        }
        if (dp[n][m] == -1) {
            dp[n][m] = dfs(n + 1, m, dp) + dfs(n, m + 1, dp);
        }
        return dp[n][m];
    }
}
