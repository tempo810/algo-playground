package leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author Tempo
 */
public class LastStoneWeight {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        for (int stone : stones) {
            maxHeap.add(stone);
        }

        while (maxHeap.size() > 1) {
            int diff = maxHeap.poll() - maxHeap.poll();
            if (diff != 0) {
                maxHeap.add(diff);
            }
        }
        return maxHeap.isEmpty() ? 0 : maxHeap.poll();
    }
}
