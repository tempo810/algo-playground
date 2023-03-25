package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author tempo
 */
public class CountUnreachablePairsOfNodesInUndirectedGraph {
    public long countPairs(int n, int[][] edges) {
        DisjointSet ds = new DisjointSet(n);
        for (int[] edge : edges) {
            ds.union(edge[0], edge[1]);
        }

        Map<Integer, Integer> frequencies = new HashMap<>();
        for (int i = 0; i < n; i++) {
            frequencies.compute(ds.find(i), (k, v) -> v == null ? 1 : v + 1);
        }

        List<Integer> componentSizes = new ArrayList<>(frequencies.values());
        long total = 0;
        int remaining = n;
        for (Integer componentSize : componentSizes) {
            remaining -= componentSize;
            total += (long) componentSize * remaining;
        }

        return total;
    }

    private static final class DisjointSet {
        private final int[] roots;
        private final int[] ranks;

        DisjointSet(int n) {
            roots = new int[n];
            ranks = new int[n];
            for (int i = 0; i < n; i++) {
                roots[i] = i;
                ranks[i] = 1;
            }
        }

        void union(int i, int j) {
            int rootI = find(i);
            int rootJ = find(j);
            if (rootI != rootJ) {
                if (ranks[rootI] > ranks[rootJ]) {
                    roots[rootJ] = rootI;
                } else {
                    roots[rootI] = roots[rootJ];
                    if (ranks[rootI] == ranks[rootJ]) {
                        ranks[rootJ]++;
                    }
                }
            }
        }

        int find(int i) {
            if (roots[i] != i) {
                roots[i] = find(roots[i]);
            }
            return roots[i];
        }
    }
}
