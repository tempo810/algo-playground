package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author tempo
 */
public class PacificAtlanticWaterFlow {
    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
        List<List<Integer>> results = new ArrayList<>();
        if (matrix.length == 0) {
            return results;
        }

        Boolean[][] pacificDp = new Boolean[matrix.length][matrix[0].length];
        Boolean[][] atlanticDp = new Boolean[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                topLeft(pacificDp, matrix, i, j);
                bottomRight(atlanticDp, matrix, i, j);
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (canReach(i, j, pacificDp, atlanticDp) && canReach(i, j, atlanticDp, pacificDp)) {
                    results.add(List.of(i, j));
                }
            }
        }
        return results;
    }

    private boolean canReach(int i, int j, Boolean[][] targetPath, Boolean[][] backupPath) {
        if (!rangeCheck(i, j, targetPath)) {
            return false;
        }

        if (targetPath[i][j]) {
            return true;
        }

        if (rangeCheck(i - 1, j, targetPath) && backupPath[i - 1][j]) {
            backupPath[i - 1][j] = false;
            boolean result = canReach(i - 1, j, targetPath, backupPath);
            backupPath[i - 1][j] = true;
            if (result) {
                return true;
            }
        }
        if (rangeCheck(i + 1, j, targetPath) && backupPath[i + 1][j]) {
            backupPath[i + 1][j] = false;
            boolean result = canReach(i + 1, j, targetPath, backupPath);
            backupPath[i + 1][j] = true;
            if (result) {
                return true;
            }
        }
        if (rangeCheck(i, j + 1, targetPath) && backupPath[i][j + 1]) {
            backupPath[i][j + 1] = false;
            boolean result = canReach(i, j + 1, targetPath, backupPath);
            backupPath[i][j + 1] = true;
            if (result) {
                return true;
            }
        }

        if (rangeCheck(i, j - 1, targetPath) && backupPath[i][j - 1]) {
            backupPath[i][j - 1] = false;
            boolean result = canReach(i, j - 1, targetPath, backupPath);
            backupPath[i][j - 1] = true;
            return result;
        }

        return false;
    }

    private boolean rangeCheck(int i, int j, Boolean[][] backupPath) {
        return i >= 0 && j >= 0 && i < backupPath.length && j < backupPath[i].length;
    }

    private boolean topLeft(Boolean[][] dp, int[][] matrix, int i, int j) {
        if (dp[i][j] == null) {
            if (i == 0 || j == 0) {
                dp[i][j] = true;
            } else {
                if (i > 0) {
                    dp[i][j] = matrix[i][j] >= matrix[i - 1][j] && topLeft(dp, matrix, i - 1, j);
                }
                if (j > 0 && !dp[i][j]) {
                    dp[i][j] = matrix[i][j] >= matrix[i][j - 1] && topLeft(dp, matrix, i, j - 1);
                }
            }
        }
        return dp[i][j];
    }


    private boolean bottomRight(Boolean[][] dp, int[][] matrix, int i, int j) {
        if (dp[i][j] == null) {
            if (i == matrix.length - 1 || j == matrix[i].length - 1) {
                dp[i][j] = true;
            } else {
                if (i < matrix.length - 1) {
                    dp[i][j] = matrix[i][j] >= matrix[i + 1][j] && bottomRight(dp, matrix, i + 1, j);
                }
                if (j < matrix[i].length - 1 && !dp[i][j]) {
                    dp[i][j] = matrix[i][j] >= matrix[i][j + 1] && bottomRight(dp, matrix, i, j + 1);
                }
            }
        }
        return dp[i][j];
    }
}
