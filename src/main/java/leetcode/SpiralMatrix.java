package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Tempo
 */
public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        dfs(0, matrix, result);
        return result;
    }

    private void dfs(int depth, int[][] matrix, List<Integer> result) {
        boolean updated = false;
        for (int i = depth; i < matrix[0].length - depth; i++) {
            result.add(matrix[depth][i]);
            updated = true;
        }

        if (!updated) {
            return;
        }
        updated = false;
        for (int i = depth + 1; i < matrix.length - depth; i++) {
            updated = true;
            result.add(matrix[i][matrix[0].length - depth - 1]);
        }

        if (!updated) {
            return;
        }

        updated = false;
        for (int i = depth + 1; i < matrix[0].length - depth; i++) {
            updated = true;
            result.add(matrix[matrix.length - depth - 1][matrix[0].length - i - 1]);
        }

        if (!updated) {
            return;
        }

        updated = false;
        for (int i = depth + 1; i < matrix.length - 1 - depth; i++) {
            updated = true;
            result.add(matrix[matrix.length - i - 1][depth]);
        }

        if (updated) {
            dfs(depth + 1, matrix, result);
        }
    }
}
