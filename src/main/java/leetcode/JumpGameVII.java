package leetcode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author Tempo
 */
public class JumpGameVII {
    public boolean canReach(String s, int minJump, int maxJump) {
        if (s.charAt(s.length() - 1) == '1') return false;
        char[] chars = s.toCharArray();
        Deque<Integer> validMovesIndex = new ArrayDeque<>();
        validMovesIndex.addLast(0);
        for (int i = 1; i < chars.length && !validMovesIndex.isEmpty() && i <= validMovesIndex.peekLast() + maxJump; i++) {
            while (!validMovesIndex.isEmpty() && validMovesIndex.peekFirst() + maxJump < i) {
                validMovesIndex.removeFirst();
            }
            if (validMovesIndex.isEmpty()) {
                return false;
            }
            if (chars[i] == '0' && i >= validMovesIndex.peekFirst() + minJump) {
                if (i == chars.length - 1) {
                    return true;
                }
                validMovesIndex.addLast(i);
            }
        }
        return false;
    }

    private boolean dfs(int index, char[] chars, int min, int max) {
        if (index == chars.length - 1) {
            return chars[index] == '0';
        }
        if (chars[index] == '1') {
            return false;
        }
        chars[index] = '1';
        for (int i = Math.min(max + index, chars.length - 1); i >= min + index; i--) {
            if (dfs(i, chars, min, max)) {
                return true;
            }
        }
        return false;
    }

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
