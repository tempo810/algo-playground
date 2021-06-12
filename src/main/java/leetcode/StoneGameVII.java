package leetcode;

import java.util.Arrays;

/**
 * @author Tempo
 */
public class StoneGameVII {
    // unable to implement...
//    public int stoneGameVIIBottomUp(int[] stones) {
//        int[] prefixSum = new int[stones.length];
//        prefixSum[0] = stones[0];
//        for (int i = 1; i < stones.length; i++) {
//            prefixSum[i] = prefixSum[i - 1] + stones[i];
//        }
//        int[][] dp = new int[stones.length][stones.length];
//
//        for (int left = stones.length - 1; left >= 0; --left) {
//            for (int right = left + 1; right < stones.length; ++right) {
//                int leftRemoval = prefixSum[right] - prefixSum[left + 1] - dp[left + 1][right];
//                int rightRemoval = prefixSum[right - 1] - prefixSum[left] - dp[left][right - 1];
//                dp[left][right] = Math.max(leftRemoval, rightRemoval);
//            }
//        }
//        return dp[0][stones.length - 1];
//    }

    public int stoneGameVII(int[] stones) {
        int[][] dp = new int[stones.length][stones.length];
        for (int[] ints : dp) {
            Arrays.fill(ints, -1);
        }
        int sum = 0;
        for (int stone : stones) {
            sum += stone;
        }
        return dfs(dp, stones, 0, stones.length - 1, sum);
    }

    private int dfs(int[][] dp, int[] stones, int start, int end, int sum) {
        if (start > end) {
            return 0;
        }
        if (dp[start][end] == -1) {
            int playHead = sum - stones[start] - dfs(dp, stones, start + 1, end, sum - stones[start]);
            int playTail = sum - stones[end] - dfs(dp, stones, start, end - 1, sum - stones[end]);
            dp[start][end] = Math.max(playHead, playTail);
        }
        return dp[start][end];
    }
}
