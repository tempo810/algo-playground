package leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;

/**
 * @author tempo
 */
public class ShortestPathWithAlternatingColors {
    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        List<Integer>[] redAdjacent = new List[n];
        List<Integer>[] blueAdjacent = new List[n];

        for (int i = 0; i < n; i++) {
            redAdjacent[i] = new ArrayList<>();
            blueAdjacent[i] = new ArrayList<>();
        }

        for (int[] redEdge : redEdges) {
            redAdjacent[redEdge[0]].add(redEdge[1]);
        }

        for (int[] blueEdge : blueEdges) {
            blueAdjacent[blueEdge[0]].add(blueEdge[1]);
        }

        int[] result = new int[n];
        Arrays.fill(result, -1);
        result[0] = 0;

        Queue<List<Integer>> nodes = new ArrayDeque<>();
        if (!redAdjacent[0].isEmpty()) {
            nodes.add(redAdjacent[0]);
            bfs(nodes, redAdjacent, blueAdjacent, result, true);
        }

        if (!blueAdjacent[0].isEmpty()) {
            nodes.add(blueAdjacent[0]);
            bfs(nodes, redAdjacent, blueAdjacent, result, false);
        }

        return result;
    }

    private void bfs(Queue<List<Integer>> nodes, List<Integer>[] redAdjacent, List<Integer>[] blueAdjacent, int[] result, boolean startWithRed) {
        boolean isRed = startWithRed;
        int step = 0;

        boolean[] redReached = new boolean[result.length];
        boolean[] blueReached = new boolean[result.length];
        if (startWithRed) {
            redReached[0] = true;
        } else {
            blueReached[0] = true;
        }

        while (!nodes.isEmpty()) {
            step++;
            List<Integer>[] alternate = isRed ? blueAdjacent : redAdjacent;
            int size = nodes.size();
            boolean[] reached = isRed ? redReached : blueReached;
            for (int i = 0; i < size; i++) {
                for (Integer node : nodes.poll()) {
                    if (!reached[node]) {
                        reached[node] = true;
                        result[node] = result[node] == -1 ? step : Math.min(step, result[node]);
                        if (!alternate[node].isEmpty()) {
                            nodes.add(alternate[node]);
                        }
                    }

                }
            }
            isRed = !isRed;
        }
    }
}
