package leetcode;

import java.util.Arrays;

/**
 * @author Tempo
 */
public class MinimumPathSum {
    public int minPathSum(int[][] grid) {
        int[][] dp = new int[grid.length][grid[0].length];
        for (int[] ints : dp) {
            Arrays.fill(ints, -1);
        }

        return find(0, 0, grid, dp);
    }

    private int find(int row, int col, int[][] grid, int[][] dp) {
        if (row == grid.length || col == grid[0].length) {
            return Integer.MAX_VALUE;
        }

        if (row == grid.length - 1 && col == grid[0].length - 1) {
            return grid[row][col];
        }

        if (dp[row][col] == -1) {
            dp[row][col] = grid[row][col] + Math.min(find(row + 1, col, grid, dp), find(row, col + 1, grid, dp));
        }
        return dp[row][col];
    }
}
