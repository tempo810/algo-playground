package leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author Tempo
 */
public class FurthestBuilding {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        int remainingBricks = bricks;
        int remainingLadders = ladders;
        PriorityQueue<Integer> usedBricks = new PriorityQueue<>(Comparator.reverseOrder()); // max heap
        for (int i = 0; i < heights.length - 1; i++) {
            int diff = heights[i + 1] - heights[i];
            if (diff <= 0) {
                continue;
            }
            if (remainingBricks >= diff) {
                remainingBricks -= diff;
                usedBricks.add(diff);
            } else if (remainingLadders > 0) {
                remainingLadders--;
                int largestGap = usedBricks.isEmpty() ? 0 : usedBricks.remove();
                remainingBricks += Math.max(0, largestGap - diff);
                usedBricks.add(Math.min(largestGap, diff));
            } else {
                return i;
            }
        }

        return heights.length - 1;
    }
}
