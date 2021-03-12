package leetcode;

/**
 * @author tempo
 */
public class HouseRobber {
    public int rob(int[] nums) {
        if (nums.length <= 1) {
            return nums.length == 0 ? 0 : nums[0];
        }

        int[] dp = new int[nums.length];
        dp[dp.length - 1] = nums[nums.length - 1];
        dp[dp.length - 2] = nums[nums.length - 2];
        int maxStolen = Math.max(dp[dp.length - 1], dp[dp.length - 2]);
        for (int i = nums.length - 3; i >= 0; i--) {
            dp[i] = Math.max(dp[i + 2], i + 3 < nums.length ? dp[i + 3] : 0) + nums[i];
            maxStolen = Math.max(maxStolen, dp[i]);
        }
        return maxStolen;
    }
}
