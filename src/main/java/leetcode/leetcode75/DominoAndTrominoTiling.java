package leetcode.leetcode75;

/**
 * @author tempo
 */
public class DominoAndTrominoTiling {

    private static final int MOD = 1000000007;

    public int numTilings(int n) {
        // 2 * 1 == 1
        // 2 * 2 == 2
        // 2 * 3 == 5
        int[] dp = new int[Math.max(4, n + 1)];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 5;
        for (int i = 4; i <= n; i++) {
            dp[i] = find(i, dp);
        }

        return dp[n];
    }

    private int find(int remaining, int[] dp) {
        if (dp[remaining] == 0) {
            int current = 1;
            int combination = 0;
            while (current < remaining) {
                combination += (dp[current] * find(remaining - current, dp));
                current++;
            }
            dp[remaining] = combination;
        }
        return dp[remaining];
    }
}
