package leetcode.leetcode75;

import java.util.Arrays;

/**
 * @author tempo
 */
public class MinCostClimbingStairs {
    public int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length];
        Arrays.fill(dp, -1);
        return findMinCost(dp, 0, cost);

    }

    private int findMinCost(int[] dp, int index, int[] cost) {
        if (index >= cost.length) {
            return 0;
        }
        if (dp[index] == -1) {
            dp[index] = cost[index] + Math.min(findMinCost(dp, index + 1, cost), findMinCost(dp, index + 2, cost));
        }
        return dp[index];
    }
}
