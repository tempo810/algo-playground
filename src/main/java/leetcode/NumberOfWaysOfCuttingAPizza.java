package leetcode;

import java.util.Arrays;

/**
 * @author tempo
 */
public class NumberOfWaysOfCuttingAPizza {
    public int ways(String[] pizza, int k) {
        int[][][] dp = new int[pizza.length][pizza[0].length()][k + 1];
        for (int[][] arrays : dp) {
            for (int[] array : arrays) {
                Arrays.fill(array, -1);
            }
        }
        for (int i = 2; i < k; i++) {
            dp[pizza.length - 1][pizza[0].length() - 1][i] = 0;
        }
        return count(pizza, 0, 0, k, dp);
    }

    private int count(String[] pizza, int row, int col, int k, int[][][] dp) {
        if (dp[row][col][k] == -1) {
            if (k == 1) {
                if (containsApple(pizza, row, col, dp.length - 1, dp[0].length - 1)) {
                    dp[row][col][k] = 1;
                }
            } else {
                long count = 0;
                boolean foundApple = false;
                int index = row;
                for (; index < dp.length; index++) {
                    if (foundApple) {
                        count += Math.max(0, count(pizza, index, col, k - 1, dp));
                    } else {
                        foundApple = containsApple(pizza, index, col, index, dp[0].length - 1);
                    }
                }

                index = col;
                foundApple = false;
                for (; index < dp[0].length; index++) {
                    if (foundApple) {
                        count += Math.max(0, count(pizza, row, index, k - 1, dp));
                    } else {
                        foundApple = containsApple(pizza, row, index, dp.length - 1, index);
                    }
                }

                dp[row][col][k] = (int) (count % 1e9 + 7);
            }
        }
        return dp[row][col][k];
    }

    private boolean containsApple(String[] pizza, int startRow, int startCol, int maxRow, int maxCol) {
        for (int i = startRow; i <= maxRow; i++) {
            for (int j = startCol; j <= maxCol; j++) {
                if (pizza[i].charAt(j) == 'A') {
                    return true;
                }
            }
        }
        return false;
    }
}
