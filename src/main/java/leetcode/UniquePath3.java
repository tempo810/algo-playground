package leetcode;

/**
 * @author Tempo
 */
public class UniquePath3 {
    private static final int[][] DIRECTIONS = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};

    public int uniquePathsIII(int[][] grid) {
        int emptySquare = 0;
        int startingRow = -1;
        int startingCol = -1;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    startingRow = i;
                    startingCol = j;
                } else if (grid[i][j] == 0) {
                    emptySquare++;
                }
            }
        }
        boolean[][] seen = new boolean[grid.length][grid[0].length];
        return count(startingRow, startingCol, emptySquare, grid, seen);
    }

    private int count(int row, int col, int remainingSquare, int[][] grid, boolean[][] seen) {
        if (row < 0 || row == grid.length || col < 0 || col == grid[0].length || seen[row][col]) {
            return 0;
        }
        if (grid[row][col] == 2) {
            return remainingSquare == 0 ? 1 : 0;
        }

        if (grid[row][col] == -1) {
            return 0;
        }
        seen[row][col] = true;
        int total = 0;
        for (int[] direction : DIRECTIONS) {
            total += count(row + direction[0], col + direction[1], grid[row][col] == 0 ? remainingSquare - 1 : remainingSquare, grid, seen);
        }
        seen[row][col] = false;
        return total;
    }
}
