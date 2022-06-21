package leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author Tempo
 */
public class FurthestBuilding {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        if (ladders >= heights.length - 1) {
            return heights.length - 1;
        }
        int remainingBricks = bricks;
        int remainingLadders = ladders;
        PriorityQueue<Integer> usedBricks = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i = 1; i < heights.length; i++) {
            int diff = heights[i] - heights[i - 1];
            if (diff > 0) {
                if (remainingBricks >= diff) {
                    usedBricks.add(diff);
                    remainingBricks -= diff;
                } else if (remainingLadders > 0) {
                    remainingLadders--;
                    if (!usedBricks.isEmpty() && diff < usedBricks.peek()) {
                        remainingBricks += usedBricks.poll() - diff;
                        usedBricks.add(diff);
                    }
                } else {
                    return i - 1;
                }
            }
        }
        return heights.length - 1;
    }
}
