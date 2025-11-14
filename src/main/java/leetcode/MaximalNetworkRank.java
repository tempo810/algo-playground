package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author tempo
 */
public class MaximalNetworkRank {
    public int maximalNetworkRank(int n, int[][] roads) {
        Set<Integer>[] graph = new Set[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new HashSet<>();
        }
        for (int[] road : roads) {
            graph[road[0]].add(road[1]);
            graph[road[1]].add(road[0]);
        }

        boolean[] visited = new boolean[n];
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                max = Math.max(find(i, graph), max);
            }
        }
        return -1;
    }

    private int find(int index, Set<Integer>[] graph) {
        final Set<Integer> nodes = graph[index];
        return 0;
    }
}
