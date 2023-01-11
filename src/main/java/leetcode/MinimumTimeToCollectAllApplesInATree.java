package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author tempo
 */
public class MinimumTimeToCollectAllApplesInATree {
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        List<Integer>[] adjEdges = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adjEdges[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            adjEdges[edge[0]].add(edge[1]);
            adjEdges[edge[1]].add(edge[0]);
        }
        return calculate(0, adjEdges, hasApple, 0);
    }

    private int calculate(int index, List<Integer>[] adjEdges, List<Boolean> hasApple, int parent) {
        int time = 0;
        for (Integer child : adjEdges[index]) {
            if (child != parent) {
                time += calculate(child, adjEdges, hasApple, index);
            }
        }

        if (index == 0) {
            return time;
        }

        return time != 0 || hasApple.get(index) ? time + 2 : 0;
    }
}
