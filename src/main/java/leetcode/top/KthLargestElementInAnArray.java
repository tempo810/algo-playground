package leetcode.top;

import java.util.PriorityQueue;

/**
 * @author tempo
 */
public class KthLargestElementInAnArray {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int num : nums) {
            if (minHeap.size() < k || minHeap.peek() < num) {
                minHeap.add(num);
            }
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
        return minHeap.poll();
    }
}
