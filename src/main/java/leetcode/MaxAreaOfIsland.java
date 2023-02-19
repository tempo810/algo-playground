package leetcode;

/**
 * @author Tempo
 */
public class MaxAreaOfIsland {
    private static final int[][] DIRECTIONS = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public int maxAreaOfIsland2(int[][] grid) {
        int maxArea = 0;
        int n = grid.length;
        int m = grid[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                maxArea = Math.max(maxArea, search(i, j, grid));
            }
        }
        return maxArea;
    }

    private int search(int n, int m, int[][] grid) {
        if (n < 0 || m < 0 || n == grid.length || m == grid[0].length || grid[n][m] == 0) {
            return 0;
        }
        grid[n][m] = 0;
        int size = 0;
        for (int[] direction : DIRECTIONS) {
            size += search(n + direction[0], m + direction[1], grid);
        }
        return size;
    }

    public int maxAreaOfIsland(int[][] grid) {
        boolean[][] seen = new boolean[grid.length][grid[0].length];
        int max = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1 && !seen[i][j]) {
                    max = Math.max(max, search(grid, i, j, seen));
                }
            }
        }
        return max;
    }

    private int search(int[][] grid, int row, int col, boolean[][] seen) {
        if (row < 0 || row == grid.length || col < 0 || col == grid[row].length || seen[row][col]) {
            return 0;
        }

        seen[row][col] = true;
        int count = grid[row][col];
        if (count == 1) {
            count += search(grid, row + 1, col, seen);
            count += search(grid, row - 1, col, seen);
            count += search(grid, row, col + 1, seen);
            count += search(grid, row, col - 1, seen);
        }
        return count;
    }
}
