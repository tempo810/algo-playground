package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author tempo
 */
public class PacificAtlanticWaterFlow {
    public List<List<Integer>> pacificAtlanticV2(int[][] matrix) {
        List<List<Integer>> results = new ArrayList<>();
        if (matrix.length == 0) {
            return results;
        }

        boolean[][] pacific = new boolean[matrix.length][matrix[0].length];
        boolean[][] atlanta = new boolean[matrix.length][matrix[0].length];

        dfsV2(0, 0, Integer.MIN_VALUE, matrix, pacific, 0, 0);
        dfsV2(matrix.length - 1, matrix[0].length - 1, Integer.MIN_VALUE, matrix, atlanta, matrix.length - 1, matrix[0].length - 1);

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (pacific[i][j] && atlanta[i][j]) {
                    results.add(List.of(i, j));
                }
            }
        }
        return results;
    }

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
            dfs(i + 1, j, matrix[i][j], matrix, ocean);
            dfs(i - 1, j, matrix[i][j], matrix, ocean);
            dfs(i, j + 1, matrix[i][j], matrix, ocean);
            dfs(i, j - 1, matrix[i][j], matrix, ocean);
        }
    }

    private void dfsV2(int i, int j, int lastValue, int[][] matrix, boolean[][] ocean, int edgeI, int edgeJ) {
        if (i < 0 || j < 0 || i >= matrix.length || j >= matrix[i].length || ocean[i][j]) {
            return;
        }

        if (i == edgeI || j == edgeJ || matrix[i][j] >= lastValue) {
            ocean[i][j] = true;
            dfsV2(i + 1, j, matrix[i][j], matrix, ocean, edgeI, edgeJ);
            dfsV2(i - 1, j, matrix[i][j], matrix, ocean, edgeI, edgeJ);
            dfsV2(i, j + 1, matrix[i][j], matrix, ocean, edgeI, edgeJ);
            dfsV2(i, j - 1, matrix[i][j], matrix, ocean, edgeI, edgeJ);
        }
    }
}
