package leetcode;

/**
 * @author tempo
 */
public class NumberOfProvinces {
    public int findCircleNum(int[][] isConnected) {
        DisjointedSet disjointedSet = new DisjointedSet(isConnected.length);
        for (int i = 0; i < isConnected.length; i++) {
            for (int j = 0; j < isConnected[i].length; j++) {
                if (isConnected[i][j] == 1) {
                    disjointedSet.union(i, j);
                }
            }
        }

        boolean[] seen = new boolean[isConnected.length];
        int total = 0;
        for (int i = 0; i < isConnected.length; i++) {
            final int root = disjointedSet.find(i);
            if (!seen[root]) {
                seen[root] = true;
                total++;
            }
        }
        return total;
    }

    private static class DisjointedSet {
        private final int[] parents;
        private final int[] ranks;

        private DisjointedSet(int n) {
            this.parents = new int[n];
            this.ranks = new int[n];
            for (int i = 0; i < n; i++) {
                this.parents[i] = i;
                this.ranks[i] = 1;
            }
        }

        int find(int n) {
            if (parents[n] == n) {
                return n;
            }
            parents[n] = find(parents[n]);
            return parents[n];
        }

        void union(int n, int m) {
            int rootN = find(n);
            int rootM = find(m);
            if (rootN != rootM) {
                int rankN = ranks[rootN];
                int rankM = ranks[rootM];
                if (rankN > rankM) {
                    this.parents[rootM] = rootN;
                } else if (rankM > rankN) {
                    this.parents[rootN] = rootM;
                } else {
                    this.parents[rootM] = rootN;
                    this.ranks[rootM]++;
                }
            }
        }
    }
}
