package leetcode;

import java.util.Arrays;

/**
 * @author Tempo
 */
public class MinimumMoveToEqualElementArray {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int[] dp = new int[nums.length];
        int totalMove = 0;
        for (int i = 1; i <= nums.length / 2; i++) {
            int diff = nums[nums.length / 2 - (i - 1)] - nums[(nums.length / 2) - i];
            dp[(nums.length / 2) - i] = diff + dp[nums.length / 2 - (i - 1)];
            totalMove += dp[(nums.length / 2) - i];

            if ((nums.length / 2) + i < nums.length) {
                diff = nums[(nums.length / 2) + i] - nums[nums.length / 2 + (i - 1)];
                dp[(nums.length / 2) + i] = diff + dp[nums.length / 2 + (i - 1)];
                totalMove += dp[(nums.length / 2) + i];
            }
        }
        return totalMove;
    }
}
