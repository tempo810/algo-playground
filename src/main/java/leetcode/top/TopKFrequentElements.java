package leetcode.top;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author tempo
 */
public class TopKFrequentElements {

    public int[] topKFrequent(int[] nums, int k) {
        int offset = 10000;
        int[] frequency = new int[20001];
        for (int num : nums) {
            frequency[num + offset]++;
        }
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparing(a -> a[1]));
        for (int i = 0; i < frequency.length; i++) {
            if (minHeap.size() < k || frequency[i] > minHeap.peek()[1]) {
                minHeap.add(new int[]{i - offset, frequency[i]});
            }
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
        int[] result = new int[k];
        for (int i = 0; i < result.length; i++) {
            result[i] = minHeap.poll()[0];
        }
        return result;
    }
}
