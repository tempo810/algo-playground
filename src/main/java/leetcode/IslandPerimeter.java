package leetcode;

/**
 * @author Tempo
 */
public class IslandPerimeter {
    private final int[][] directions = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    public int islandPerimeter(int[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    return dfs(i, j, grid, visited);
                }
            }
        }
        return 0;
    }

    private int dfs(int row, int col, int[][] grid, boolean[][] visited) {
        if (row < 0 || col < 0 || row == grid.length || col == grid[0].length || grid[row][col] == 0) {
            return 1;
        }

        if (visited[row][col]) {
            return 0;
        }

        visited[row][col] = true;
        int perimeter = 0;
        for (int[] direction : directions) {
            perimeter += dfs(row + direction[0], col + direction[1], grid, visited);
        }
        return perimeter;
    }
}
