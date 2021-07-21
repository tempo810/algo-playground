package leetcode;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author Tempo
 */
public class ShortestPathInBinaryMatrix {
    public final int[][] directions = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};

    public int shortestPathBinaryMatrix(int[][] grid) {
        if (grid[0][0] == 1) {
            return -1;
        }

        grid[0][0] = 1;
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{0, 0});
        int step = 1;

        while (!queue.isEmpty()) {
            for (int i = queue.size(); i > 0; i--) {
                int[] indices = queue.remove();

                if (indices[0] == grid.length - 1 && indices[1] == grid.length - 1) {
                    return step;
                }

                for (int[] direction : directions) {
                    int x = indices[0] + direction[0];
                    int y = indices[1] + direction[1];
                    if (x >= 0 && y >= 0 && x < grid.length && y < grid.length && grid[x][y] == 0) {
                        grid[x][y] = 1;
                        queue.add(new int[]{x, y});
                    }
                }

            }
            step++;
        }
        return -1;
    }
}
