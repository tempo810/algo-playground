package leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author Tempo
 */
public class TwoCityScheduling {
    public int twoCitySchedCost(int[][] costs) {
        PriorityQueue<int[]> heap = new PriorityQueue<>(Comparator.comparingInt(cost -> cost[1] - cost[0]));
        int half = costs.length / 2;
        int totalCost = 0;
        for (int[] cost : costs) {
            if (heap.size() < half) {
                heap.add(cost);
            } else {
                int[] currentLargestDiff = heap.peek();
                if (cost[1] - cost[0] > currentLargestDiff[1] - currentLargestDiff[0]) {
                    totalCost += heap.poll()[1];
                    heap.add(cost);
                } else {
                    totalCost += cost[1];
                }
            }
        }
        while (!heap.isEmpty()) {
            totalCost += heap.poll()[0];
        }
        return totalCost;
    }
}
