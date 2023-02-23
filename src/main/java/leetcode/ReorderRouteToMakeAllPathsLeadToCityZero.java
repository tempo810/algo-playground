package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author tempo
 */
public class ReorderRouteToMakeAllPathsLeadToCityZero {
    public int minReorder(int n, int[][] connections) {
        List<Integer>[] adjacents = new List[n];
        List<Integer>[] inverted = new List[n];

        for (int i = 0; i < n; i++) {
            adjacents[i] = new ArrayList<>();
            inverted[i] = new ArrayList<>();
        }

        for (int[] connection : connections) {
            adjacents[connection[0]].add(connection[1]);
            inverted[connection[1]].add(connection[0]);
        }
        return countReorder(0, adjacents, inverted, new boolean[n]);
    }

    private int countReorder(int root, List<Integer>[] adjacents, List<Integer>[] inverted, boolean[] seen) {
        seen[root] = true;
        int reorder = 0;
        final List<Integer> children = adjacents[root];
        for (Integer child : children) {
            if (!seen[child]) {
                reorder++;
                reorder += countReorder(child, adjacents, inverted, seen);
            }
        }
        for (Integer parents : inverted[root]) {
            if (!seen[parents]) {
                reorder += countReorder(parents, adjacents, inverted, seen);
            }
        }
        return reorder;
    }
}
