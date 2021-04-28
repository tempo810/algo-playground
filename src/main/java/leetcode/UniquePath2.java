package leetcode;

/**
 * @author Tempo
 */
public class UniquePath2 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        Integer[][] dp = new Integer[obstacleGrid.length][obstacleGrid[0].length];
        return helper(obstacleGrid, dp, 0, 0);

    }

    private int helper(int[][] obstacleGrid, Integer[][] dp, int i, int j) {
        if (i >= obstacleGrid.length || j >= obstacleGrid[i].length) {
            return 0;
        }
        if (i == obstacleGrid.length - 1 && j == obstacleGrid[i].length - 1) {
            dp[i][j] = obstacleGrid[i][j] == 1 ? 0 : 1;
        }
        if (dp[i][j] == null) {
            dp[i][j] = obstacleGrid[i][j] == 0 ? helper(obstacleGrid, dp, i + 1, j) + helper(obstacleGrid, dp, i, j + 1) : 0;
        }
        return dp[i][j];
    }
}
