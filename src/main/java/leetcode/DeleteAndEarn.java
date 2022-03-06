package leetcode;

import java.util.Arrays;

/**
 * @author Tempo
 */
public class DeleteAndEarn {
    public int deleteAndEarn(int[] nums) {
        int[] counts = new int[10001];
        int max = 0;
        for (int num : nums) {
            counts[num]++;
            max = Math.max(num, max);
        }

        int[] dp = new int[max + 1];
        Arrays.fill(dp, -1);
        return findMax(1, counts, dp);
    }

    private int findMax(int index, int[] counts, int[] dp) {
        if (index >= dp.length) {
            return 0;
        }

        if (dp[index] == -1) {
            int takeCurrent = counts[index] * index + findMax(index + 2, counts, dp);
            int notTakingCurrent = findMax(index + 1, counts, dp);
            dp[index] = Math.max(takeCurrent, notTakingCurrent);
        }
        return dp[index];
    }
}
