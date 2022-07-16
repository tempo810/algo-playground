package leetcode;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

/**
 * @author Tempo
 */
public class OutOfBoundaryPaths {
    private static final int[][] DIRECTIONS = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    private static final long MOD = (long) 1e9 + 7;

    // BFS bruteforce
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        Queue<int[]> grids = new ArrayDeque<>(); // bfs to store grid to make next move
        grids.add(new int[]{startRow, startColumn});

        long mod = (long) 1e9 + 7;

        int maxWidth = m - 1;
        int maxHeight = n - 1;
        long result = 0;

        for (int i = 0; i < maxMove; i++) {
            int queueLength = grids.size();
            for (int j = 0; j < queueLength; j++) {
                int[] grid = grids.poll();

                for (int[] direction : DIRECTIONS) {
                    int nextX = grid[0] + direction[0];
                    int nextY = grid[1] + direction[1];
                    if (nextX >= 0 && nextY >= 0 && nextX <= maxWidth && nextY <= maxHeight) {
                        grids.add(new int[]{nextX, nextY});
                    } else {
                        result++;
                        result %= mod;
                    }
                }
            }
        }
        return (int) result;
    }

    public int findPathsDp(int m, int n, int maxMove, int startRow, int startColumn) {
        if (maxMove == 0) {
            return 0;
        }
        int[][][] dp = new int[m][n][maxMove + 1];
        for (int[][] ints : dp) {
            for (int[] anInt : ints) {
                Arrays.fill(anInt, -1);
            }
        }
        return dfs(startRow, startColumn, maxMove, dp);
    }

    private int dfs(int row, int col, int remainingMoves, int[][][] dp) {
        if (dp[row][col][remainingMoves] == -1) {
            int height = dp.length - 1;
            int width = dp[0].length - 1;
            long result = 0;
            for (int[] direction : DIRECTIONS) {
                int nextRow = row + direction[0];
                int nextCol = col + direction[1];
                if (nextRow < 0 || nextCol < 0 || nextRow > height || nextCol > width) {
                    result++;
                } else if (remainingMoves > 1) {
                    result += dfs(nextRow, nextCol, remainingMoves - 1, dp);
                }
            }
            dp[row][col][remainingMoves] = (int) (result % MOD);
        }
        return dp[row][col][remainingMoves];
    }
}
