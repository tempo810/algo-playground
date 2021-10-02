package leetcode;

/**
 * @author Tempo
 */

public class CherryPickup {
    private final int[][][] directions = {{{1, 0}, {1, 0}}, {{1, 0}, {0, 1}}, {{0, 1}, {0, 1}}, {{0, 1}, {1, 0}}};

    public int cherryPickup(int[][] grid) {
        Integer[][][][] dp = new Integer[grid.length][grid[0].length][grid.length][grid[0].length];
        return Math.max(0, find(grid, dp, 0, 0, 0, 0));
    }

    private int find(int[][] grid, Integer[][][][] dp, int row1, int col1, int row2, int col2) {
        if (row1 == grid.length || row2 == grid.length || col1 == grid[0].length || col2 == grid[0].length
                || grid[row1][col1] == -1 || grid[row2][col2] == -1) {
            return Integer.MIN_VALUE;
        }
        if (row1 == grid.length - 1 && col1 == grid[0].length - 1) {
            return grid[row1][col1];
        }

        if (dp[row1][col1][row2][col2] == null) {
            int currentPick = grid[row1][col1];
            if (col1 != col2 || row1 != row2) {
                currentPick += grid[row2][col2];
            }
            int maxPick = Integer.MIN_VALUE;
            for (int[][] direction : directions) {
                maxPick = Math.max(maxPick, find(grid, dp, row1 + direction[0][0], col1 + direction[0][1], row2 + direction[1][0], col2 + direction[1][1]));
            }
            dp[row1][col1][row2][col2] = currentPick + maxPick;
        }
        return dp[row1][col1][row2][col2];
    }
}
