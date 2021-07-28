package leetcode;

/**
 * @author Tempo
 */
public class StoneGameIV {
    public static void main(String[] args) {
        var sol = new StoneGameIV();
        System.out.println(sol.stoneGameV(new int[]{6, 2, 3, 4, 5, 5}));
        System.out.println(sol.stoneGameV(new int[]{7, 7, 7, 7, 7, 7, 7}));
    }

    public int stoneGameV(int[] stoneValue) {
        int[][] dp = new int[2][stoneValue.length];
        dp[0][0] = stoneValue[0];
        dp[1][stoneValue.length - 1] = stoneValue[stoneValue.length - 1];
        for (int i = 1; i < stoneValue.length; i++) {
            dp[0][i] = dp[0][i - 1] + stoneValue[i];
            dp[1][stoneValue.length - 1 - i] = dp[1][stoneValue.length - i] + stoneValue[stoneValue.length - 1 - i];
        }
        return findMaxScore(0, stoneValue.length - 1, dp);
    }

    private int findMaxScore(int left, int right, int[][] dp) {
        if (right == left) {
            return dp[0][left] - dp[0][left - 1];
        }
        int diff = Integer.MAX_VALUE;
        int optimalIndex = left;
        int optimalLeftScore = Integer.MAX_VALUE;
        int optimalRightScore = Integer.MAX_VALUE;

        for (int i = left + 1; i < right; i++) {
            int leftScore = dp[0][i] - (left == 0 ? 0 : dp[0][left - 1]);
            int rightScore = dp[1][i + 1] - (right == dp[1].length - 1 ? 0 : dp[1][right + 1]);
            if (Math.abs(leftScore - rightScore) < Math.abs(diff)) {
                diff = leftScore - rightScore;
                optimalIndex = i;
                optimalLeftScore = leftScore;
                optimalRightScore = rightScore;
            }
        }
        if (optimalLeftScore == optimalRightScore) {
            return optimalLeftScore + Math.max(findMaxScore(left, optimalIndex, dp), findMaxScore(optimalIndex + 1, right, dp));
        }
        if (optimalLeftScore < optimalRightScore) {
            return optimalLeftScore + findMaxScore(left, optimalIndex, dp);
        } else {
            return optimalRightScore + findMaxScore(optimalIndex + 1, right, dp);
        }
    }
}
