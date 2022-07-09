package leetcode;

import java.util.PriorityQueue;

/**
 * @author Tempo
 */
public class JumpGameVI {
    public int maxResult(int[] nums, int k) {
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> Integer.compare(b[0], a[0]));
        int result = nums[0];
        maxHeap.add(new int[]{nums[0], 0});

        for (int i = 1; i < nums.length; i++) {
            while (maxHeap.peek()[1] < (i - k)) {
                maxHeap.poll();
            }
            result = maxHeap.peek()[0] + nums[i];
            maxHeap.add(new int[]{result, i});
        }
        return result;
    }
}
