package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author tempo
 */
public class CheapestFlightsWithinKStop {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<int[]>[] edges = new List[n];
        for (int i = 0; i < n; i++) {
            edges[i] = new ArrayList<>();
        }
        for (int[] flight : flights) {
            edges[flight[0]].add(flight);
        }
        int minCost = dfs(src, dst, k + 1, edges, new boolean[n]);
        return minCost == Integer.MAX_VALUE ? -1 : minCost;
    }

    private int dfs(int src, int dst, int remainingStop, List<int[]>[] edges, boolean[] stopped) {
        if (remainingStop < 0) {
            return Integer.MAX_VALUE;
        }
        if (src == dst) {
            return 0;
        }

        int minCost = Integer.MAX_VALUE;
        for (int[] flight : edges[src]) {
            if (!stopped[flight[1]]) {
                stopped[flight[1]] = true;
                int remainingCost = dfs(flight[1], dst, remainingStop - 1, edges, stopped);
                if (remainingCost != Integer.MAX_VALUE) {
                    minCost = Math.min(remainingCost + flight[2], minCost);
                }
                stopped[flight[1]] = false;
            }
        }
        return minCost;
    }
}
