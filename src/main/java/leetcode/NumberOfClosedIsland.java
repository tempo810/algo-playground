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

    public int closedIslandUnionFind(int[][] grid) {
        int[] ids = new int[grid.length * grid[0].length];
        int count = 0;
        while (count < ids.length) {
            ids[count] = count;
            count++;
        }
        for (int i = 1; i < grid.length - 1; i++) {
            for (int j = 1; j < grid[i].length - 1; j++) {
                if (grid[i][j] == 0) {
                    for (int[] direction : DIRECTIONS) {
                        int nextRow = i + direction[0];
                        int nextCol = j + direction[1];
                        if (grid[nextRow][nextCol] == 0) {
                            union(id(i, j, grid[0].length), id(nextRow, nextCol, grid[0].length), ids, grid[0].length);
                        }
                    }
                }
            }
        }
        int total = 0;
        for (int i = 1; i < grid.length - 1; i++) {
            for (int j = 1; j < grid[0].length - 1; j++) {
                int key = i * grid[0].length + j;
                if (grid[i][j] == 0 && ids[key] == key) {
                    total++;
                }
            }
        }
        return total;
    }

    private void union(int a, int b, int[] ids, int n) {
        int rootA = root(a, ids);
        int rootB = root(b, ids);
        if (rootA != rootB) {
            int i = rootB / n;
            int j = rootB % n;
            if (i == 0 || i == (ids.length / n) - 1 || j == 0 || j == n - 1) {
                ids[rootA] = rootB;
            } else {
                ids[rootB] = rootA;
            }
        }
    }

    private int root(int id, int[] ids) {
        while (ids[id] != id) {
            id = ids[id];
        }
        return id;
    }

    private int id(int i, int j, int n) {
        return i * n + j;
    }
}
