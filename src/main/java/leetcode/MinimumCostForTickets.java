package leetcode;

import java.util.Arrays;

/**
 * @author tempo
 */
public class MinimumCostForTickets {
    public int mincostTickets(int[] days, int[] costs) {
        int[] dp = new int[days[days.length - 1] + 1];
        Arrays.fill(dp, -1);
        return travel(1, days, costs, dp);

    }

    private int travel(int day, int[] days, int[] costs, int[] dp) {
        if (day >= dp.length) {
            return 0;
        }

        int index = Arrays.binarySearch(days, day);
        if (index < 0) {
            day = days[(index + 1) * -1];
        }

        if (dp[day] == -1) {
            int minCost = costs[0] + travel(day + 1, days, costs, dp);
            minCost = Math.min(costs[1] + travel(day + 7, days, costs, dp), minCost);
            minCost = Math.min(costs[2] + travel(day + 30, days, costs, dp), minCost);
            dp[day] = minCost;
        }
        return dp[day];
    }
}
