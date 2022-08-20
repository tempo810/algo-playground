package leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author tempo
 */
public class MinimumNumberOfRefuelingStops {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        int totalFuel = startFuel;
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());

        for (int[] station : stations) {
            while (totalFuel < station[0]) {
                if (maxHeap.isEmpty()) {
                    return -1;
                }
                totalFuel += maxHeap.poll();
            }
            maxHeap.offer(station[1]);
        }

        while ((totalFuel < target)) {
            if (maxHeap.isEmpty()) {
                return -1;
            }
            totalFuel += maxHeap.poll();
        }

        return stations.length - maxHeap.size();
    }
}
