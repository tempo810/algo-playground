package leetcode.leetcode75;

import java.util.HashSet;
import java.util.Set;

/**
 * @author tempo
 */
public class NumberOfProvinces {
    public int findCircleNum(int[][] isConnected) {
        int[] roots = new int[isConnected.length];
        for (int i = 0; i < roots.length; i++) {
            roots[i] = i;
        }
        for (int i = 0; i < isConnected.length; i++) {
            for (int j = 0; j < isConnected[i].length; j++) {
                if (i != j && isConnected[i][j] == 1) {
                    union(roots, i, j);
                }
            }
        }

        Set<Integer> uniqueRoots = new HashSet<>();
        for (int i = 0; i < isConnected.length; i++) {
            uniqueRoots.add(find(roots, i));
        }
        return uniqueRoots.size();
    }

    private void union(int[] roots, int i, int j) {
        int rootI = find(roots, i);
        int rootJ = find(roots, j);
        if (rootI == rootJ) {
            return;
        }
        if (rootI < rootJ) {
            roots[rootJ] = rootI;
        } else {
            roots[rootI] = rootJ;
        }
    }

    private int find(int[] roots, int i) {
        if (roots[i] == i) {
            return i;
        }
        return find(roots, roots[i]);
    }
}
