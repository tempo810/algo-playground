package leetcode;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author Tempo
 */
public class UpdateMatrix {
    private static final int[][] SHIFTS = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public int[][] updateMatrixV2(int[][] mat) {
        Queue<int[]> queue = new ArrayDeque<>();
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                if (mat[i][j] == 0) {
                    queue.add(new int[]{i, j});
                } else {
                    mat[i][j] = Integer.MAX_VALUE;
                }
            }
        }
        int distance = 1;
        while (!queue.isEmpty()) {
            for (int k = queue.size(); k > 0; k--) {
                int[] index = queue.remove();
                for (int[] shift : SHIFTS) {
                    int i = index[0] + shift[0];
                    int j = index[1] + shift[1];
                    if (valid(i, j, mat.length, mat[0].length) && mat[i][j] > distance) {
                        mat[i][j] = distance;
                        queue.add(new int[]{i, j});
                    }
                }
            }
            distance++;
        }
        return mat;
    }

    private boolean valid(int i, int j, int row, int col) {
        return i >= 0 && j >= 0 && i < row && j < col;
    }
}
