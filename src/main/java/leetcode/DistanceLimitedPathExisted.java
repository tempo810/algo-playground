package leetcode;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author tempo
 */
public class DistanceLimitedPathExisted {
    public boolean[] distanceLimitedPathsExist(int n, int[][] edgeList, int[][] queries) {
        int[][] indexedQueries = new int[queries.length][4];
        for (int i = 0; i < queries.length; i++) {
            int[] indexedQuery = Arrays.copyOf(queries[i], 4);
            indexedQuery[3] = i;
            indexedQueries[i] = indexedQuery;
        }
        Arrays.sort(edgeList, Comparator.comparing(ints -> ints[2]));
        Arrays.sort(indexedQueries, Comparator.comparing(ints -> ints[2]));

        DisjointSet ds = new DisjointSet(n);
        boolean[] result = new boolean[queries.length];
        int edgeListIndex = 0;
        for (int[] indexedQuery : indexedQueries) {
            while (edgeListIndex < edgeList.length && edgeList[edgeListIndex][2] < indexedQuery[2]) {
                ds.union(edgeList[edgeListIndex][0], edgeList[edgeListIndex][1]);
                edgeListIndex++;
            }
            result[indexedQuery[3]] = ds.find(indexedQuery[0]) == ds.find(indexedQuery[1]);
        }
        return result;
    }

    private static class DisjointSet {
        private final int[] root;
        private final int[] rank;

        public DisjointSet(int n) {
            root = new int[n];
            rank = new int[n];
            for (int i = 0; i < n; i++) {
                root[i] = i;
                rank[i] = 1;
            }
        }

        int find(int n) {
            if (root[n] != n) {
                root[n] = find(root[n]);
            }
            return root[n];
        }

        void union(int n, int m) {
            int rootN = find(n);
            int rootM = find(m);
            if (rootM != rootN) {
                if (rank[rootN] > rank[rootM]) {
                    root[rootM] = rootN;
                } else if (rank[rootM] > rank[rootN]) {
                    root[rootN] = rootM;
                } else {
                    root[rootM] = rootN;
                    rank[rootN]++;
                }
            }
        }
    }
}
