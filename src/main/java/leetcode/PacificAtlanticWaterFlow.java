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

        int[][] pacific = new int[matrix.length][matrix[0].length];
        int[][] atlanta = new int[matrix.length][matrix[0].length];

        for (int i = 0; i < matrix.length; i++) {
            dfs(i, 0, Integer.MIN_VALUE, matrix, pacific);
            dfs(i, matrix[i].length - 1, Integer.MIN_VALUE, matrix, atlanta);
        }

        for (int i = 0; i < matrix[0].length; i++) {
            dfs(0, i, Integer.MIN_VALUE, matrix, pacific);
            dfs(matrix.length - 1, i, Integer.MIN_VALUE, matrix, atlanta);
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (pacific[i][j] == 1 && atlanta[i][j] == 1) {
                    results.add(List.of(i, j));
                }
            }
        }
        return results;
    }

    private void dfs(int i, int j, int lastValue, int[][] matrix, int[][] ocean) {
        if (i < 0 || j < 0 || i >= matrix.length || j >= matrix[i].length || ocean[i][j] == 1) {
            return;
        }
        if (matrix[i][j] >= lastValue) {
            ocean[i][j] = 1;
        }
        dfs(i + 1, j, matrix[i][j], matrix, ocean);
        dfs(i - 1, j, matrix[i][j], matrix, ocean);
        dfs(i, j + 1, matrix[i][j], matrix, ocean);
        dfs(i, j - 1, matrix[i][j], matrix, ocean);
    }
}
