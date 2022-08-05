package leetcode;

/**
 * @author tempo
 */
public class CombinationSumIV {
    public int combinationSum4(int[] nums, int target) {
        Integer[] dp = new Integer[target + 1];
        dp[0] = 1;
        return dfs(nums, target, dp);
    }

    private int dfs(int[] nums, int target, Integer[] dp) {
        if (target < 0) {
            return 0;
        }
        if (dp[target] == null) {
            int total = 0;
            for (int num : nums) {
                total += dfs(nums, target - num, dp);
            }
            dp[target] = total;
        }
        return dp[target];
    }
}
