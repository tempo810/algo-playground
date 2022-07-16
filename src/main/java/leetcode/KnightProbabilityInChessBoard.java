package leetcode;

import java.util.Arrays;

/**
 * @author Tempo
 */
public class KnightProbabilityInChessBoard {
    private static final int[][] DIRECTIONS = new int[][]{{-1, -2}, {-2, -1}, {-1, 2}, {-2, 1}, {1, -2}, {2, -1}, {1, 2}, {2, 1}};

    public double knightProbability(int n, int k, int row, int column) {
        double[][][] dp = new double[n][n][k + 1];
        for (double[][] arr2d : dp) {
            for (double[] arr : arr2d) {
                Arrays.fill(arr, -1);
            }
        }
        return dfs(row, column, k, dp);
    }

    private double dfs(int row, int column, int step, double[][][] dp) {
        if (row < 0 || column < 0 || row >= dp.length || column >= dp.length) return 0;

        if (dp[row][column][step] == -1) {
            double result = 0;
            if (step == 0) {
                result = 1;
            } else {
                for (int[] direction : DIRECTIONS) {
                    int nextRow = row + direction[0];
                    int nextCol = column + direction[1];
                    result += dfs(nextRow, nextCol, step - 1, dp);
                }
                result /= 8;
            }
            dp[row][column][step] = result;
        }
        return dp[row][column][step];
    }
}
