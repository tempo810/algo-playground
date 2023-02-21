package leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * @author tempo
 */
public class TimeNeededToInformAllEmployees {
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        List<Integer>[] graph = new List[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < n; i++) {
            int root = manager[i];
            if (root != -1) {
                graph[root].add(i);
            }
        }

        Queue<Integer> nodes = new ArrayDeque<>();
        nodes.add(headID);
        int maxTime = 0;
        while (!nodes.isEmpty()) {
            int size = nodes.size();
            for (int i = 0; i < size; i++) {
                int node = nodes.poll();
                final List<Integer> children = graph[node];
                for (Integer child : children) {
                    informTime[child] += informTime[node];
                    maxTime = Math.max(maxTime, informTime[child]);
                    nodes.add(child);
                }
            }
        }
        return maxTime;
    }
}
