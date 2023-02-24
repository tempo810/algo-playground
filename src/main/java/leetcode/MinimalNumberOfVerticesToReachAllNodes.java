package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author tempo
 */
public class MinimalNumberOfVerticesToReachAllNodes {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        boolean[] graph = new boolean[n];
        for (List<Integer> edge : edges) {
            graph[edge.get(1)] = true;
        }
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < graph.length; i++) {
            if (!graph[i]) {
                result.add(i);
            }
        }
        return result;
    }
}
