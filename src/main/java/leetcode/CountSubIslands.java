package leetcode;

/**
 * @author tempo
 */
public class CountSubIslands {

    private static final int[][] DIRECTIONS = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int n = grid1.length;
        int m = grid1[0].length;
        int total = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid2[i][j] == 1 && isSubIsland(i, j, grid1, grid2)) {
                    total++;
                }
            }
        }

        return total;
    }

    private boolean isSubIsland(int n, int m, int[][] grid1, int[][] grid2) {
        if (n < 0 || m < 0 || n == grid1.length || m == grid1[0].length || grid2[n][m] == 0) {
            return true;
        }
        grid2[n][m] = 0;
        if (grid1[n][m] == 0) {
            for (int[] direction : DIRECTIONS) {
                setNonIsland(n + direction[0], m + direction[1], grid2);
            }
            return false;
        } else {
            boolean isSubIsland = true;
            for (int[] direction : DIRECTIONS) {
                isSubIsland &= isSubIsland(n + direction[0], m + direction[1], grid1, grid2);
            }
            return isSubIsland;
        }
    }

    private void setNonIsland(int n, int m, int[][] grid) {
        if (n < 0 || m < 0 || n == grid.length || m == grid[0].length || grid[n][m] == 0) {
            return;
        }
        grid[n][m] = 0;
        for (int[] direction : DIRECTIONS) {
            setNonIsland(direction[0] + n, direction[1] + m, grid);
        }
    }
}
