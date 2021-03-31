package leetcode;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author tempo
 */
public class RussianDollEnvelopes {
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, Comparator.comparingInt(a -> a[0] * a[1]));
        int[] dp = new int[envelopes.length];
        Arrays.fill(dp, 1);
        int max = 0;
        for (int i = 0; i < envelopes.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (envelopes[j][0] < envelopes[i][0] && envelopes[j][1] < envelopes[i][1]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }

            max = Math.max(dp[i], max);
        }
        return max;
    }
}
