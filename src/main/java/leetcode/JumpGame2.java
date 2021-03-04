package leetcode;

/**
 * @author tempo
 */
public class JumpGame2 {
    public int jump(int[] nums) {
        if (nums.length <= 2) {
            return nums.length - 1;
        }

        int lastSavedIndex = Integer.MAX_VALUE;
        int lastSaved = Integer.MIN_VALUE;
        int maxSaved = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > 1 && i < nums.length - 2) {
                maxSaved += nums[i] - 1;
                maxSaved -= Math.max(0, lastSaved - (i - lastSavedIndex) + 1);
                lastSaved = nums[i] - 1;
                lastSavedIndex = i;
            }
        }
        return Math.max(nums.length - 1 - maxSaved, 1);
    }

    public int jumpV2(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }
        Integer[] dp = new Integer[nums.length - 1]; // -1 = no possible path, 0 = unknown
        return dp(0, nums, dp);
    }

    private int dp(int start, int[] nums, Integer[] dp) {
        if (nums[start] + start >= nums.length - 1) {
            return 1;
        }

        int possibleStep = nums[start];
        if (possibleStep == 0) {
            return -1;
        }

        int minStep = Integer.MAX_VALUE;
        for (int i = 1; i <= possibleStep; i++) {
            if (dp[start + i - 1] == null) {
                dp[start + i - 1] = dp(start + i, nums, dp);
            }
            if (dp[start + i - 1] >= 0) {
                minStep = Math.min(minStep, dp[start + i - 1]);
            }
        }
        return minStep == Integer.MAX_VALUE ? -1 : minStep + 1;
    }
}
