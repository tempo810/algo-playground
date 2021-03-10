package leetcode;

/**
 * @author Tempo
 */
public class UniquePathsWithObstacles {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        Integer[][] dp = new Integer[obstacleGrid.length][obstacleGrid[0].length];
        return countPath(0, 0, obstacleGrid, dp);
    }

    private int countPath(int m, int n, int[][] obstacleGrid, Integer[][] dp) {
        if (dp[m][n] == null) {
            if (obstacleGrid[m][n] == 1) {
                dp[m][n] = 0;
            } else if (m == obstacleGrid.length - 1 && n == obstacleGrid[0].length - 1) {
                dp[m][n] = 1;
            } else {
                int down = m < obstacleGrid.length - 1 ? countPath(m + 1, n, obstacleGrid, dp) : 0;
                int right = n < obstacleGrid[m].length - 1 ? countPath(m, n + 1, obstacleGrid, dp) : 0;
                dp[m][n] = down + right;
            }
        }

        return dp[m][n];
    }
}
