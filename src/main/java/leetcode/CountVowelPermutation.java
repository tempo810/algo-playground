package leetcode;

import java.util.Arrays;

/**
 * @author tempo
 */
public class CountVowelPermutation {
    private static final int[][] LOOKUP = new int[][]{{1}, {0, 2}, {0, 1, 3, 4}, {2, 4}, {0}};
    private static final long MOD = (long) 1e9 + 7;

    public int countVowelPermutation(int n) {
        long[][] dp = new long[n + 1][5];
        Arrays.fill(dp[1], 1);

        for (int i = 2; i < dp.length; i++) {
            Arrays.fill(dp[i], 0);
        }

        for (int i = 2; i <= n; i++) {
            for (int lastCharacter = 0; lastCharacter < LOOKUP.length; lastCharacter++) {
                for (int nextCharacter : LOOKUP[lastCharacter]) {
                    dp[i][nextCharacter] += dp[i - 1][lastCharacter];
                    dp[i][nextCharacter] %= MOD;
                }
            }
        }

        long total = 0;
        for (long perVowelCount : dp[n]) {
            total += perVowelCount;
            total %= MOD;
        }
        return (int) total;
    }
}
