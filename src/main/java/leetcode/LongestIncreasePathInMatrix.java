package leetcode;

import java.util.Arrays;

/**
 * @author Tempo
 */
public class LongestIncreasePathInMatrix {
    public int longestIncreasingPath(int[][] matrix) {
        int[][] dp = new int[matrix.length][matrix[0].length];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        int max = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                max = Math.max(max, dfs(i, j, matrix, dp));
            }
        }
        return max;
    }

    private int dfs(int row, int col, int[][] matrix, int[][] dp) {
        if (dp[row][col] != -1) {
            return dp[row][col];
        }
        int currentMax = 1;
        if (row > 0 && matrix[row][col] < matrix[row - 1][col]) {
            currentMax = Math.max(currentMax, 1 + dfs(row - 1, col, matrix, dp));
        }
        if (col > 0 && matrix[row][col] < matrix[row][col - 1]) {
            currentMax = Math.max(currentMax, 1 + dfs(row, col - 1, matrix, dp));
        }
        if (row < matrix.length - 1 && matrix[row][col] < matrix[row + 1][col]) {
            currentMax = Math.max(currentMax, 1 + dfs(row + 1, col, matrix, dp));
        }
        if (col < matrix[row].length - 1 && matrix[row][col] < matrix[row][col + 1]) {
            currentMax = Math.max(currentMax, 1 + dfs(row, col + 1, matrix, dp));
        }
        dp[row][col] = currentMax;
        return currentMax;
    }
}
