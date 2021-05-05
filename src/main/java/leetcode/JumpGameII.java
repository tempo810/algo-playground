package leetcode;

import java.util.Arrays;

/**
 * @author Tempo
 */
public class JumpGameII {
    public int jump(int[] nums) {
        if (nums.length <= 2) {
            return nums.length - 1;
        }
        int[] dp = new int[nums.length];
        Arrays.fill(dp, Integer.MAX_VALUE);
        for (int i = nums.length - 2; i >= 0; i--) {
            searchMinStep(i, nums, dp);
        }

        return dp[0];
    }

    private void searchMinStep(int i, int[] nums, int[] dp) {
        int currentStep = nums[i];
        if (i + currentStep >= nums.length - 1) {
            dp[i] = 1;
        } else {
            for (int step = 1; step <= currentStep && step + i < nums.length - 1; step++) {
                dp[i] = Math.min(dp[i + step], dp[i]);
            }
            if (dp[i] != Integer.MAX_VALUE) {
                dp[i]++;
            }
        }
    }
}
