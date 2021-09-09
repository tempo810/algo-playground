package leetcode;

import java.util.Arrays;

/**
 * @author Tempo
 */
public class LargestPlusSign {
    public int orderOfLargestPlusSign(int n, int[][] mines) {
        int[][] grid = new int[n][n];
        for (int[] ints : grid) {
            Arrays.fill(ints, 1);

        }

        for (int[] mine : mines) {
            grid[mine[0]][mine[1]] = 0;
        }

        int[][] leftDp = leftDp(grid);
        int[][] rightDp = rightDp(grid);
        int[][] upDp = upDp(grid);
        int[][] downDp = downDp(grid);
        int maxOrder = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    int currentOrder = Math.min(Math.min(leftDp[i][j], rightDp[i][j]), Math.min(upDp[i][j], downDp[i][j]));
                    maxOrder = Math.max(maxOrder, currentOrder);
                }
            }
        }
        return maxOrder;
    }

    private int[][] downDp(int[][] mines) {
        int[][] dp = new int[mines.length][mines[0].length];
        for (int i = mines[0].length - 1; i >= 0; i--) {
            dp[dp.length - 1][i] = mines[mines.length - 1][i];
            for (int j = mines.length - 2; j >= 0; j--) {
                if (mines[j][i] == 1) {
                    dp[j][i] = dp[j + 1][i] + 1;
                }
            }
        }
        return dp;
    }

    private int[][] upDp(int[][] mines) {
        int[][] dp = new int[mines.length][mines[0].length];
        for (int i = 0; i < mines[0].length; i++) {
            dp[0][i] = mines[0][i];
            for (int j = 1; j < mines.length; j++) {
                if (mines[j][i] == 1) {
                    dp[j][i] = dp[j - 1][i] + 1;
                }
            }
        }
        return dp;
    }

    private int[][] rightDp(int[][] mines) {
        int[][] dp = new int[mines.length][mines[0].length];
        for (int i = 0; i < mines.length; i++) {
            dp[i][dp[i].length - 1] = mines[i][mines[i].length - 1];
            for (int j = mines[i].length - 2; j >= 0; j--) {
                if (mines[i][j] == 1) {
                    dp[i][j] = dp[i][j + 1] + 1;
                }
            }
        }
        return dp;
    }

    private int[][] leftDp(int[][] mines) {
        int[][] dp = new int[mines.length][mines[0].length];
        for (int i = 0; i < mines.length; i++) {
            dp[i][0] = mines[i][0];
            for (int j = 1; j < mines[i].length; j++) {
                if (mines[i][j] == 1) {
                    dp[i][j] = dp[i][j - 1] + 1;
                }
            }
        }
        return dp;
    }
}
