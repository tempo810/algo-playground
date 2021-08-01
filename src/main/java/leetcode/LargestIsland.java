package leetcode;

import java.util.ArrayDeque;
import java.util.List;
import java.util.Queue;

/**
 * @author Tempo
 */
public class LargestIsland {
    public List<int[]> SHIFTS = List.of(new int[]{1, 0}, new int[]{0, 1}, new int[]{-1, 0}, new int[]{0, -1});

    public int largestIsland(int[][] grid) {
        boolean noZero = true;
        int largestArea = Integer.MIN_VALUE;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 0) {
                    noZero = false;
                    grid[i][j] = 1;
                    largestArea = Math.max(bfs(grid, i, j), largestArea);
                    grid[i][j] = 0;
                }
            }
        }
        return noZero ? grid.length * grid[0].length : largestArea;
    }

    private int bfs(int[][] grid, int i, int j) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        Queue<int[]> queue = new ArrayDeque<>();
        int total = 0;
        queue.add(new int[]{i, j});
        while (!queue.isEmpty()) {
            for (int k = queue.size(); k > 0; k--) {
                int[] location = queue.remove();
                int i1 = location[0];
                int j1 = location[1];
                if (i1 < 0 || j1 < 0 || i1 == grid.length || j1 == grid[i].length || visited[i1][j1] || grid[i1][j1] == 0) {
                    continue;
                }
                total++;
                visited[i1][j1] = true;
                for (int[] shift : SHIFTS) {
                    queue.add(new int[]{i1 + shift[0], j1 + shift[1]});
                }
            }
        }
        return total;
    }
}
