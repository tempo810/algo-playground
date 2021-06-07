package leetcode;

/**
 * @author Tempo
 */
public class MinCostOfClimbingStair {
    public int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[2];
        dp[1] = cost[cost.length - 1];
        dp[0] = cost[cost.length - 2];

        for (int i = cost.length - 3; i >= 0; i--) {
            int last = dp[0];
            dp[0] = cost[i] + Math.min(dp[0], dp[1]);
            dp[1] = last;
        }

        return Math.min(dp[0], dp[1]);
    }
}
