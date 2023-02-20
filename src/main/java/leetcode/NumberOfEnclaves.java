package leetcode;

/**
 * @author tempo
 */
public class NumberOfEnclaves {
    private static final int[][] DIRECTIONS = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    public int numEnclavesDFS(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        for (int i = 0; i < m; i++) {
            overrideNotEnclave(0, i, grid);
            overrideNotEnclave(n - 1, i, grid);
        }
        for (int i = 1; i < n - 1; i++) {
            overrideNotEnclave(i, 0, grid);
            overrideNotEnclave(i, m - 1, grid);
        }

        int count = 0;
        for (int i = 1; i < n - 1; i++) {
            for (int j = 1; j < m - 1; j++) {
                if (grid[i][j] == 1) {
                    count++;
                }
            }
        }
        return count;
    }

    private void overrideNotEnclave(int n, int m, int[][] grid) {
        if (n < 0 || m < 0 || n == grid.length || m == grid[n].length || grid[n][m] == 0) {
            return;
        }
        grid[n][m] = 0;
        for (int[] direction : DIRECTIONS) {
            overrideNotEnclave(n + direction[0], m + direction[1], grid);
        }
    }

    public int numEnclaves(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int total = 0;
        DisjointSet ds = new DisjointSet(n * m);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    total++;
                    for (int[] direction : DIRECTIONS) {
                        int i2 = i + direction[0];
                        int j2 = j + direction[1];
                        if (i2 >= 0 && j2 >= 0 && i2 < n && j2 < m && grid[i2][j2] == 1) {
                            ds.union(i * m + j, i2 * m + j2);
                        }
                    }
                }
            }
        }
        boolean[] notEnclaves = new boolean[n * m];
        for (int i = 0; i < m; i++) {
            if (grid[0][i] == 1) {
                notEnclaves[ds.find(i)] = true;
            }
            if (grid[grid.length - 1][i] == 1) {
                notEnclaves[ds.find((grid.length - 1) * m + i)] = true;
            }
        }

        for (int i = 1; i < n - 1; i++) {
            if (grid[i][0] == 1) {
                notEnclaves[ds.find(i * m)] = true;
            }

            if (grid[i][m - 1] == 1) {
                notEnclaves[ds.find(((i + 1) * m) - 1)] = true;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1 && notEnclaves[ds.find(i * m + j)]) {
                    total--;
                }
            }
        }

        return total;
    }

    private static class DisjointSet {
        private final int[] ranks;

        private final int[] roots;

        DisjointSet(int n) {
            this.ranks = new int[n];
            this.roots = new int[n];
            for (int i = 0; i < n; i++) {
                this.ranks[i] = 1;
                this.roots[i] = i;
            }
        }

        int find(int i) {
            if (roots[i] == i) {
                return i;
            }
            roots[i] = find(roots[i]);
            return roots[i];
        }

        void union(int i, int j) {
            final int rootI = find(i);
            final int rootJ = find(j);
            if (rootI == rootJ) {
                return;
            }

            if (ranks[rootI] > ranks[rootJ]) {
                roots[rootJ] = rootI;
            } else if (ranks[rootJ] > ranks[rootI]) {
                roots[rootI] = rootJ;
            } else {
                roots[rootJ] = rootI;
                ranks[rootI]++;
            }
        }
    }
}
