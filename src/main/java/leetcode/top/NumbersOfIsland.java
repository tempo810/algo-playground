package leetcode.top;

/**
 * @author tempo
 */
public class NumbersOfIsland {

    private final int[][] directions = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] visited = new boolean[n][m];
        int numberOfIslands = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j] && grid[i][j] == '1') {
                    numberOfIslands++;
                    dfs(i, j, grid, visited);
                }
            }
        }
        return numberOfIslands;
    }

    private void dfs(int n, int m, char[][] grid, boolean[][] visited) {
        if (n < 0 || m < 0 || n == grid.length || m == grid[0].length) {
            return;
        }
        if (!visited[n][m] && grid[n][m] == '1') {
            visited[n][m] = true;
            for (int[] direction : this.directions) {
                dfs(n + direction[0], m + direction[1], grid, visited);
            }
        }
    }
}
