package leetcode;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author Tempo
 */
public class JumpGameVII {
    public int maxResult(int[] nums, int k) {
        Integer[] dp = new Integer[nums.length];
        dp[nums.length - 1] = nums[nums.length - 1];
        return helper(0, nums, dp, k);
    }

    private int helper(int currentIndex, int[] nums, Integer[] dp, int k) {
        if (dp[currentIndex] == null) {
            int value = Integer.MIN_VALUE;
            for (int i = 1; i <= k && currentIndex + i < nums.length; i++) {
                value = Math.max(helper(currentIndex + i, nums, dp, k), value);
            }
            dp[currentIndex] = nums[currentIndex] + value;
        }
        return dp[currentIndex];
    }

    public int maxResultV2(int[] nums, int k) {
        Queue<int[]> maxHeap = new PriorityQueue<>((a, b) -> Integer.compare(b[1], a[1]));
        int last = nums[nums.length - 1];
        for (int i = nums.length - 1; i >= 0; i--) {
            last = helperV2(i, nums, k, maxHeap);
        }
        return last;
    }

    private int helperV2(int currentIndex, int[] nums, int k, Queue<int[]> maxHeap) {
        while (!maxHeap.isEmpty() && maxHeap.peek()[0] > currentIndex + k) {
            maxHeap.poll();
        }
        int[] current = new int[2];
        current[0] = currentIndex;
        current[1] = maxHeap.isEmpty() ? nums[currentIndex] : maxHeap.peek()[1] + nums[currentIndex];
        maxHeap.add(current);
        return
                current[1];
    }
}
