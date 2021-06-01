package leetcode;

/**
 * @author Tempo
 */
public class MaxAreaOfIsland {
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
