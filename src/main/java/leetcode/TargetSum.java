package leetcode;

/**
 * @author Tempo
 */
public class TargetSum {
    public int findTargetSumWays(int[] nums, int target) {
        return dfs(nums, target, 0, 0);
    }

    private int dfs(int[] nums, int target, int depth, int current) {
        if (depth == nums.length) {
            return current == target ? 1 : 0;
        }
        int total = 0;
        total += dfs(nums, target, depth + 1, current + nums[depth]);
        total += dfs(nums, target, depth + 1, current - nums[depth]);
        return total;
    }
}
