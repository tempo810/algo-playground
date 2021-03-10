package leetcode;

/**
 * @author Tempo
 */
public class NumberOfIsland {
    public int numIslands(char[][] grid) {
        boolean[][] found = new boolean[grid.length][grid[0].length];
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1' && !found[i][j]) {
                    count++;
                    mark(i, j, found, grid);
                }
            }
        }

        return count;
    }

    private void mark(int i, int j, boolean[][] found, char[][] grid) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[i].length || grid[i][j] == '0' || found[i][j]) {
            return;
        }

        found[i][j] = true;
        mark(i - 1, j, found, grid);
        mark(i + 1, j, found, grid);
        mark(i, j - 1, found, grid);
        mark(i, j + 1, found, grid);
    }
}
