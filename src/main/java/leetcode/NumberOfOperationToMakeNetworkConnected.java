package leetcode;

/**
 * @author tempo
 */
public class NumberOfOperationToMakeNetworkConnected {
    public int makeConnected(int n, int[][] connections) {
        if (connections.length < n - 1) {
            return -1;
        }
        DisjointSet ds = new DisjointSet(n);
        for (int[] connection : connections) {
            ds.union(connection[0], connection[1]);
        }

        int uniqueRoots = 0;
        boolean[] found = new boolean[n];
        for (int i = 0; i < n; i++) {
            final int root = ds.find(i);
            if (!found[root]) {
                found[root] = true;
                uniqueRoots++;
            }
        }
        return uniqueRoots - 1;
    }

    private static final class DisjointSet {
        private final int[] roots;

        private final int[] ranks;

        public DisjointSet(int n) {
            this.roots = new int[n];
            this.ranks = new int[n];

            for (int i = 0; i < n; i++) {
                this.roots[i] = i;
                this.ranks[i] = 1;
            }
        }

        int find(int n) {
            if (roots[n] == n) {
                return n;
            }
            return roots[n] = find(roots[n]);
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
}
