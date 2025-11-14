package leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author tempo
 */
public class MaximumPerformanceOfATeam {
    public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
        PriorityQueue<int[]> candidates = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        for (int i = 0; i < n; i++) {
            if (candidates.size() < k) {
                final int[] candidate = {speed[i], efficiency[i]};
                candidates.add(candidate);
            } else {
                final int[] leastEfficientCandidate = candidates.peek();
                if (speed[i] >= leastEfficientCandidate[0] && efficiency[i] >= leastEfficientCandidate[1]) {
                    candidates.poll();
                    candidates.add(new int[]{speed[i], efficiency[i]});
                }
            }
        }
        long teamSize = 0;
        int minEfficient = candidates.peek()[1];
        while (!candidates.isEmpty()) {
            teamSize += candidates.poll()[0];
        }
        return (int) ((teamSize * minEfficient) % (1e9 + 7));
    }
}
