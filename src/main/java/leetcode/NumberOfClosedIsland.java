package leetcode;

/**
 * @author Tempo
 */
public class NumberOfClosedIsland {
    private static final int[][] DIRECTIONS = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public int closedIsland(int[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int total = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 0 && !visited[i][j] && search(i, j, grid, visited)) {
                    total++;
                }
            }
        }
        return total;
    }

    private boolean search(int i, int j, int[][] grid, boolean[][] visited) {
        if (grid[i][j] == 1) {
            return true;
        }
        visited[i][j] = true;
        for (int[] direction : DIRECTIONS) {
            int i1 = direction[0] + i;
            int j1 = direction[1] + j;
            if (i1 < 0 || j1 < 0 || i1 == visited.length || j1 == visited[i].length || (!visited[i1][j1] && !search(i1, j1, grid, visited))) {
                visited[i][j] = false;
                return false;
            }
        }
        return true;
    }
}
