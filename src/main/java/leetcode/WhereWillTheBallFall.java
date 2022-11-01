package leetcode;

/**
 * @author tempo
 */
public class WhereWillTheBallFall {
    public int[] findBall(int[][] grid) {
        Integer[][] dp = new Integer[grid.length][grid[0].length];
        int[] result = new int[grid[0].length];
        for (int i = 0; i < grid[0].length; i++) {
            result[i] = find(grid, 0, i, dp);
        }
        return result;
    }

    private int find(int[][] grid, int row, int col, Integer[][] dp) {
        if (row == grid.length) {
            return col;
        }

        if (dp[row][col] == null) {
            if (grid[row][col] == 1) {
                if (col + 1 < grid[0].length && grid[row][col + 1] == 1) {
                    dp[row][col] = find(grid, row + 1, col + 1, dp);
                } else {
                    dp[row][col] = -1;
                }
            } else {
                if (col - 1 >= 0 && grid[row][col - 1] == -1) {
                    dp[row][col] = find(grid, row + 1, col - 1, dp);
                } else {
                    dp[row][col] = -1;
                }
            }
        }
        return dp[row][col];
    }
}
