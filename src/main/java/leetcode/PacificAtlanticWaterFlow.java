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
                if (reach(matrix, pacificDp, i, j, 0, 0) && reach(matrix, atlanticDp, i, j, matrix.length - 1, matrix[0].length - 1)) {
                    results.add(List.of(i, j));
                }
            }
        }
        return results;
    }

    private boolean reach(int[][] matrix, Boolean[][] dp, int i, int j, int targetI, int targetJ) {
        if (dp[i][j] == null) {
            if (i == targetI || j == targetJ) {
                dp[i][j] = true;
            } else {
                dp[i][j] = false;
                if (i < matrix.length - 1) {
                    dp[i][j] = matrix[i][j] >= matrix[i + 1][j] && reach(matrix, dp, i + 1, j, targetI, targetJ);
                }
                if (j < matrix[i].length - 1 && (dp[i][j] == null || !dp[i][j])) {
                    dp[i][j] = matrix[i][j] >= matrix[i][j + 1] && reach(matrix, dp, i, j + 1, targetI, targetJ);
                }
                if (i > 0 && (dp[i][j] == null || !dp[i][j])) {
                    dp[i][j] = matrix[i][j] >= matrix[i - 1][j] && reach(matrix, dp, i - 1, j, targetI, targetJ);
                }
                if (j > 0 && (dp[i][j] == null || !dp[i][j])) {
                    dp[i][j] = matrix[i][j] >= matrix[i][j - 1] && reach(matrix, dp, i, j - 1, targetI, targetJ);
                }
            }
        }
        return dp[i][j];
    }
}
