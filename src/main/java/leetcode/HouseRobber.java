package leetcode;

/**
 * @author tempo
 */
public class HouseRobber {
    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }
        return dp[nums.length - 1];
    }

    public int robV2(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }

        int currentBest = Math.max(nums[0], nums[1]);
        int lastBest = nums[0];

        for (int i = 2; i < nums.length; i++) {
            int temp = Math.max(lastBest + nums[i], currentBest);
            lastBest = currentBest;
            currentBest = temp;
        }

        return currentBest;
    }
}
