package leetcode;

import java.util.Arrays;

/**
 * @author Tempo
 */

//TODO: figure out later
public class CherryPickup {
    public int cherryPickup(int[][] grid) {
        int[][] dp = new int[grid.length][grid[0].length];
        fill(dp);
        boolean[][] path = new boolean[grid.length][grid[0].length];
        int firstHalf = forwardDp(grid, dp, path, 0, 0);
        if (firstHalf == -1) {
            return 0;
        } else {
            path[0][0] = true;
            fill(dp);
            return firstHalf + returnDp(grid, dp, path, grid.length - 1, grid[0].length - 1);
        }
    }

    private int returnDp(int[][] grid, int[][] dp, boolean[][] path, int i, int j) {
        if (i < 0 || j < 0) {
            return 0;
        }
        if (dp[i][j] == -2) {
            if (grid[i][j] == -1) {
                dp[i][j] = -1;
            } else {
                dp[i][j] = Math.max(returnDp(grid, dp, path, i - 1, j), returnDp(grid, dp, path, i, j - 1));
                if (dp[i][j] > -1 && !path[i][j]) {
                    dp[i][j] += grid[i][j];
                }
            }
        }
        return dp[i][j];
    }

    private void fill(int[][] dp) {
        for (int[] ints : dp) {
            Arrays.fill(ints, -2);
        }
    }

    private int forwardDp(int[][] grid, int[][] dp, boolean[][] path, int i, int j) {
        if (i == grid.length || j == grid[i].length) {
            return 0;
        }
        if (dp[i][j] == -2) {
            if (grid[i][j] == -1) {
                dp[i][j] = -1;
            } else {
                int down = forwardDp(grid, dp, path, i + 1, j);
                int right = forwardDp(grid, dp, path, i, j + 1);
                if (down == -1 && right == -1) {
                    dp[i][j] = -1;
                } else if (down > right) {
                    if (i + 1 < grid.length) {
                        path[i + 1][j] = true;
                    }
                    dp[i][j] = grid[i][j] + down;
                } else {
                    if (j + 1 < grid[i].length) {
                        path[i][j + 1] = true;
                    }
                    dp[i][j] = grid[i][j] + right;
                }
            }
        }
        return dp[i][j];
    }
}
