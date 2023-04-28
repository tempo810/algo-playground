package leetcode;

import java.util.Arrays;
import java.util.HashSet;

/**
 * @author tempo
 */
public class SimilarStringGroup {

    public int numSimilarGroups(String[] strs) {
        String[] set = new HashSet<>(Arrays.asList(strs)).toArray(String[]::new);
        DisjointSet disjointSet = new DisjointSet(set.length);
        for (int i = 0; i < set.length - 1; i++) {
            for (int j = i + 1; j < set.length; j++) {
                int distance = distanceOf(set[i], set[j]);
                if (distance == 0 || distance == 2) {
                    disjointSet.union(i, j);
                }
            }
        }
        int result = 0;
        for (int i = 0; i < set.length; i++) {
            if (disjointSet.find(i) == i) {
                result++;
            }
        }
        return result;
    }

    private int distanceOf(String str, String str1) {
        int distance = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != str1.charAt(i)) {
                distance++;
            }
        }
        return distance;
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
