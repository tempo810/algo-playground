package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author tempo
 */
public class AllPathFromSourceToTarget {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>>[] memo = new List[graph.length];
        return dfs(0, graph, memo);
    }

    private List<List<Integer>> dfs(int currentIndex, int[][] graph, List<List<Integer>>[] memo) {
        if (memo[currentIndex] == null) {
            int[] children = graph[currentIndex];
            List<List<Integer>> path = new ArrayList<>();
            if (currentIndex == graph.length - 1) {
                path.add(List.of(currentIndex));
            } else {
                for (int child : children) {
                    List<List<Integer>> childrenPaths = dfs(child, graph, memo);
                    for (List<Integer> childrenPath : childrenPaths) {
                        List<Integer> currentPath = new ArrayList<>();
                        currentPath.add(currentIndex);
                        currentPath.addAll(childrenPath);
                        path.add(currentPath);
                    }
                }
            }

            memo[currentIndex] = path;
        }
        return memo[currentIndex];
    }
}
