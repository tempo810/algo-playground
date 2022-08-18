package leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author tempo
 */
public class ReduceArraySizeToHalf {
    public int minSetSize(int[] arr) {
        Map<Integer, Integer> occurrences = new HashMap<>();
        for (int value : arr) {
            occurrences.compute(value, (k, v) -> v == null ? 1 : v + 1);
        }
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        int total = 0;
        int target = (arr.length + 1) / 2;
        for (Integer occurrence : occurrences.values()) {
            if (total < target) {
                minHeap.add(occurrence);
                total += occurrence;
            } else if (occurrence > minHeap.peek()) {
                total += occurrence - minHeap.poll();
                minHeap.add(occurrence);
            }

            while (total - minHeap.poll() >= target) {
                total -= minHeap.poll();
            }
        }
        return minHeap.size();
    }
}
