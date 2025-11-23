package leetcode.leetcode75;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author tempo
 */
public class ReorderRoutesToMakeAllPathLeadToTheCity {
    public int minReorder(int n, int[][] connections) {
        Map<Integer, Set<int[]>> connectors = new HashMap<>();
        for (int[] connection : connections) {
            connectors.compute(connection[0], (k, v) -> {
                if (v == null) {
                    v = new HashSet<>();
                }
                v.add(connection);
                return v;
            });

            connectors.compute(connection[1], (k, v) -> {
                if (v == null) {
                    v = new HashSet<>();
                }
                v.add(connection);
                return v;
            });
        }
        ;
        return countInvert(0, connectors);

    }

    private int countInvert(int i, Map<Integer, Set<int[]>> connections) {
        final Set<int[]> adjacents = connections.remove(i);
        if (adjacents == null || adjacents.isEmpty()) {
            return 0;
        }
        int inverted = 0;
        for (int[] adjacent : adjacents) {
            int origin = adjacent[0];
            int destination = adjacent[1];
            int next;
            if (origin == i) {
                inverted++;
                next = destination;
            } else {
                next = origin;
            }
            connections.computeIfPresent(next, (k, v) -> {
                v.remove(adjacent);
                if (!v.isEmpty()) {
                    return v;
                }
                return null;
            });
            inverted += countInvert(next, connections);
        }
        return inverted;
    }
}
