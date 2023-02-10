package leetcode;

/**
 * @author tempo
 */
public class AsFarFromLandAsPossible {
    public int maxDistance(int[][] grid) {
        int[][] dp = new int[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                dp[i][j] = grid[i][j] == 1 ? 0 : Integer.MAX_VALUE;
            }
        }

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (i > 0 && dp[i - 1][j] != Integer.MAX_VALUE) {
                    dp[i][j] = Math.min(dp[i - 1][j] + 1, dp[i][j]);
                }
                if (j > 0 && dp[i][j - 1] != Integer.MAX_VALUE) {
                    dp[i][j] = Math.min(dp[i][j - 1] + 1, dp[i][j]);
                }
            }
        }

        int result = 0;
        for (int i = dp.length - 1; i >= 0; i--) {
            for (int j = dp[i].length - 1; j >= 0; j--) {
                if (i < dp.length - 1 && dp[i + 1][j] != Integer.MAX_VALUE) {
                    dp[i][j] = Math.min(dp[i + 1][j] + 1, dp[i][j]);
                }
                if (j < dp[i].length - 1 && dp[i][j + 1] != Integer.MAX_VALUE) {
                    dp[i][j] = Math.min(dp[i][j + 1] + 1, dp[i][j]);
                }
                if (dp[i][j] != Integer.MAX_VALUE) {
                    result = Math.max(dp[i][j], result);
                }
            }
        }
        return result == 0 ? -1 : result;
    }
}
