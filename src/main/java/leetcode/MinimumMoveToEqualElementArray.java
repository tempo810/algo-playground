package leetcode;

import java.util.Arrays;

/**
 * @author Tempo
 */
public class MinimumMoveToEqualElementArray {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int median = nums[nums.length / 2];
        int totalMove = 0;
        for (int i = 0; i < nums.length; i++) {
            totalMove += Math.abs(nums[i] - median);
        }
        return totalMove;
    }
}
