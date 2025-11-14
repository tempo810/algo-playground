package leetcode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author tempo
 */
public class SmallestStringWithSwap {
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        DisjointSet disjointSet = new DisjointSet(s.length());
        for (List<Integer> pair : pairs) {
            disjointSet.union(pair.get(0), pair.get(1));
        }

        Map<Integer, int[]> connectedNodes = new HashMap<>();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            final int root = disjointSet.find(i);
            connectedNodes.computeIfAbsent(root, key -> new int[26])[chars[i] - 'a']++;
        }

        for (int i = 0; i < chars.length; i++) {
            final int root = disjointSet.find(i);
            chars[i] = findFirst(connectedNodes.get(root));
        }
        return new String(chars);
    }

    private char findFirst(int[] ints) {
        for (int i = 0; i < ints.length; i++) {
            if (ints[i] > 0) {
                ints[i]--;
                return (char) (i + 'a');
            }
        }
        return (char) -1;
    }

    private static class DisjointSet {
        private int[] roots;

        private int[] ranks;

        DisjointSet(int n) {
            roots = new int[n];
            ranks = new int[n];

            for (int i = 0; i < n; i++) {
                roots[i] = i;
                ranks[i] = 1;
            }
        }

        int find(int n) {
            if (roots[n] != n) {
                roots[n] = find(roots[n]);
            }
            return roots[n];
        }

        void union(int n, int m) {
            int rootN = find(n);
            int rootM = find(m);
            if (rootN != rootM) {
                if (ranks[rootN] > ranks[rootM]) {
                    roots[rootM] = rootN;
                } else if (ranks[rootM] > ranks[rootN]) {
                    roots[rootN] = rootM;
                } else {
                    roots[rootM] = rootN;
                    ranks[rootN]++;
                }
            }
        }
    }
}
