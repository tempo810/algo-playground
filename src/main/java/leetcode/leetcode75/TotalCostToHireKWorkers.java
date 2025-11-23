package leetcode.leetcode75;

import java.util.PriorityQueue;

/**
 * @author tempo
 */
public class TotalCostToHireKWorkers {
    public long totalCost(int[] costs, int k, int candidates) {
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(candidates * 2, (a, b) -> a[0] != b[0] ? a[0] - b[0] : a[1] - b[1]);
        int left = -1;
        int right = costs.length;
        while (left < right && minHeap.size() < candidates * 2) {
            left++;
            minHeap.add(new int[]{costs[left], left});
            if (left + 1 < right) {
                right--;
                minHeap.add(new int[]{costs[right], right});
            }
        }
        long cost = 0;
        for (int i = 0; i < k; i++) {
            final int[] hiring = minHeap.poll();
            cost += hiring[0];
            if (left + 1 < right) {
                boolean isLeft = hiring[1] <= left;
                if (isLeft) {
                    left++;
                    minHeap.add(new int[]{costs[left], left});
                } else {
                    right--;
                    minHeap.add(new int[]{costs[right], right});
                }
            }
        }
        return cost;
    }
}
