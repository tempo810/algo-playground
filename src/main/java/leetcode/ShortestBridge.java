package leetcode;

/**
 * @author tempo
 */
public class ShortestBridge {
    private static final int[][] DIRECTIONS = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    public int shortestBridge(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        Coordinates island1 = null;
        Coordinates island2 = null;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    Coordinates coordinates = new Coordinates(i, j, i, j);
                    findAllCoordinates(i, j, grid, coordinates);
                    if (island1 == null) {
                        island1 = coordinates;
                    } else {
                        island2 = coordinates;
                        break;
                    }
                }
            }
        }

        int x = findMinDistance(island1.minX, island1.maxX, island2.minX, island2.maxX);
        int y = findMinDistance(island1.minY, island1.maxY, island2.minY, island2.maxY);
        final int result = x + y;
        if (result <= 1) {
            return result;
        }
        return result - 1;
    }

    private int findMinDistance(int minX, int maxX, int minX1, int maxX1) {
        // check overlap
        if ((maxX >= minX1 && maxX <= maxX1) || (maxX1 >= minX && maxX1 <= maxX)) {
            return 0;
        }

        if (maxX < minX1) {
            return minX1 - maxX;
        }
        return minX - maxX1;
    }

    private void findAllCoordinates(int i, int j, int[][] grid, Coordinates coordinates) {
        if (i < 0 || j < 0 || i == grid.length || j == grid[0].length || grid[i][j] == 0) {
            return;
        }

        grid[i][j] = 0;
        coordinates.minX = Math.min(coordinates.minX, i);
        coordinates.maxX = Math.max(coordinates.maxX, i);
        coordinates.minY = Math.min(coordinates.minY, j);
        coordinates.maxY = Math.max(coordinates.maxY, j);

        for (int[] direction : DIRECTIONS) {
            findAllCoordinates(i + direction[0], j + direction[1], grid, coordinates);
        }
    }

    private static final class Coordinates {
        int minX;
        int minY;
        int maxX;
        int maxY;

        public Coordinates(int minX, int minY, int maxX, int maxY) {
            this.minX = minX;
            this.minY = minY;
            this.maxX = maxX;
            this.maxY = maxY;
        }
    }
}
