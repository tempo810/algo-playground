package leetcode.leetcode75;

import java.util.Arrays;

/**
 * @author tempo
 */
public class HouseRobber {
    public int rob(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, -1);
        return findMax(0, dp, nums);
    }

    private int findMax(int i, int[] dp, int[] nums) {
        if (i >= nums.length) {
            return 0;
        }
        if (dp[i] == -1) {
            dp[i] = Math.max(nums[i] + findMax(i + 2, dp, nums), findMax(i + 1, dp, nums));
        }
        return dp[i];
    }

    public int robBottomUp(int[] nums) {
        int prevUnrobbed = 0;
        int lastRobbed = 0;
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            int notRobThisHouse = Math.max(lastRobbed, prevUnrobbed);
            int robThisHouse = prevUnrobbed + nums[i];
            max = Math.max(robThisHouse, notRobThisHouse);
            prevUnrobbed = notRobThisHouse;
            lastRobbed = robThisHouse;
        }
        return max;
    }
}
