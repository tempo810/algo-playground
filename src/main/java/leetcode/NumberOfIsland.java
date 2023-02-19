package leetcode;

/**
 * @author Tempo
 */
public class NumberOfIsland {
    private static final int[][] DIRECTIONS = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    public int numIslandsUF(char[][] grid) {
        DisjointSet disjointSet = new DisjointSet(grid.length * grid[0].length);
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    for (int[] direction : DIRECTIONS) {
                        int nextI = i + direction[0];
                        int nextJ = j + direction[1];
                        if (nextI >= 0
                                && nextJ >= 0
                                && nextI < grid.length
                                && nextJ < grid[nextI].length
                                && grid[nextI][nextJ] == '1') {
                            disjointSet.union(i * j + j, nextI * nextJ + nextJ);
                        }
                    }
                }
            }
        }
        boolean[] seen = new boolean[grid.length * grid[0].length];
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    final int root = disjointSet.find(i * grid[i].length + j);
                    if (!seen[root]) {
                        seen[root] = true;
                        count++;
                    }
                }
            }
        }
        return count;
    }


    private static class DisjointSet {
        private final int[] roots;
        private final int[] ranks;

        private DisjointSet(int n) {
            roots = new int[n];
            ranks = new int[n];
            for (int i = 0; i < n; i++) {
                roots[i] = i;
                ranks[i] = 1;

            }
        }

        int find(int n) {
            if (roots[n] == n) {
                return n;
            }
            roots[n] = find(roots[n]);
            return roots[n];
        }

        void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);

            if (rootX == rootY) {
                return;
            }

            if (ranks[rootX] > ranks[rootY]) {
                roots[rootY] = rootX;
            } else if (ranks[rootY] > ranks[rootX]) {
                roots[rootX] = rootY;
            } else {
                roots[rootY] = rootX;
                ranks[rootX]++;
            }
        }
    }

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
