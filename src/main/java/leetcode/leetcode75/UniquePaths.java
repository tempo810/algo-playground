package leetcode.leetcode75;

import java.util.Arrays;

/**
 * @author tempo
 */
public class UniquePaths {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -1);
        }
        dp[m - 1][n - 1] = 1;
        return find(0, 0, dp);
    }

    private int find(int row, int col, int[][] dp) {
        if (row == dp.length || col == dp[0].length) {
            return 0;
        }
        if (dp[row][col] == -1) {
            dp[row][col] = find(row + 1, col, dp) + find(row, col + 1, dp);
        }
        return dp[row][col];
    }
}
