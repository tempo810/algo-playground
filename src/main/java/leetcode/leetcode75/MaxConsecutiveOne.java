package leetcode.leetcode75;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author tempo
 */
public class MaxConsecutiveOne {
    public int longestOnes(int[] nums, int k) {
        Deque<Integer> flippedPos = new ArrayDeque<>();
        int currentLength = 0;
        int maxLength = 0;
        for (int i = 0; i < nums.length; i++) {
            currentLength++;
            if (nums[i] != 1) {
                flippedPos.add(i);
                if (flippedPos.size() > k) {
                    int newNonZeroHead = flippedPos.removeFirst() + 1;
                    currentLength = i - newNonZeroHead;
                }
            }
            maxLength = Math.max(currentLength, maxLength);
        }
        return maxLength;
    }
}
