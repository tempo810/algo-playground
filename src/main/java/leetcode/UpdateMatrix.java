package leetcode;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;

/**
 * @author Tempo
 */
public class UpdateMatrix {
    public int[][] updateMatrix(int[][] mat) {
        Queue<int[]> queue = new ArrayDeque<>();
        boolean[][] visited = new boolean[mat.length][mat[0].length];
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                if (mat[i][j] != 0) {
                    int level = 1;
                    fillQueue(queue, i, j);
                    visited[i][j] = true;
                    while (!queue.isEmpty()) {
                        for (int k = queue.size(); k > 0; k--) {
                            int[] index = queue.remove();
                            if (index[0] < 0 || index[0] == mat.length || index[1] < 0 || index[1] == mat.length) {
                                continue;
                            }
                            if (mat[index[0]][index[1]] == 0) {
                                mat[i][j] = level;
                                queue.clear();
                                for (boolean[] booleans : visited) {
                                    Arrays.fill(booleans, false);
                                }
                                break;
                            } else {
                                if (!visited[index[0]][index[1]]) {
                                    visited[index[0]][index[1]] = true;
                                    fillQueue(queue, index[0], index[1]);
                                }
                            }
                        }
                        level++;
                    }
                }
            }
        }
        return mat;
    }

    private void fillQueue(Queue<int[]> queue, int i, int j) {
        queue.addAll(List.of(new int[]{i - 1, j}, new int[]{i + 1, j}, new int[]{i, j - 1}, new int[]{i, j + 1}));
    }
}
