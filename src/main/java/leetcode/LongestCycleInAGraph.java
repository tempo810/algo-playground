package leetcode;

/**
 * @author tempo
 */
public class LongestCycleInAGraph {
    public int longestCycle(int[] edges) {
        int longestCycle = -1;
        int[] visited = new int[edges.length];
        for (int i = 0; i < edges.length; i++) {
            if (visited[i] == 0) {
                visited[i] = Math.max(countCircularPath(edges, visited, i, edges[i]), longestCycle);
                longestCycle = Math.max(visited[i], longestCycle);
            }
        }
        return longestCycle;
    }

    private int countCircularPath(int[] edges, int[] visited, int slow, int fast) {
        if (visited[slow] != 0) {
            return visited[slow];
        }
        if (fast == -1) {
            return -1;
        }

        if (fast == slow) {
            int count = 0;
            do {
                count++;
                fast = edges[edges[fast]];
                slow = edges[slow];
            } while (fast != slow);
            visited[slow] = count;
            return visited[slow];
        }

        int next = edges[fast];
        int count = -1;
        if (next != -1) {
            count = countCircularPath(edges, visited, edges[slow], edges[next]);
            visited[next] = count;
        }
        visited[slow] = count;
        visited[fast] = count;
        return count;
    }
}
