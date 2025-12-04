package leetcode.leetcode75;

import java.util.Arrays;

/**
 * @author tempo
 */
public class LongestCommonSubsequence {
    public int longestCommonSubsequence(String text1, String text2) {
        int[][] dp = new int[text1.length()][text2.length()];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -1);

        }
        return find(text1, text2, 0, 0, dp);
    }

    private int find(String text1, String text2, int start1, int start2, int[][] dp) {
        if (start1 == text1.length() || start2 == text2.length()) {
            return 0;
        }
        if (dp[start1][start2] == -1) {
            int max = 0;
            for (int i = start1; i < text1.length(); i++) {
                for (int j = start2; j < text2.length(); j++) {
                    if (text1.charAt(i) == text2.charAt(j)) {
                        max = Math.max(max, 1 + find(text1, text2, i + 1, j + 1, dp));
                    }
                }
            }
            dp[start1][start2] = max;
        }
        return dp[start1][start2];
    }

    public int longestCommonSubsequenceBottomUp(String text1, String text2) {
        int[][] dp = new int[text1.length() + 1][text2.length() + 1];
        for (int i = 0; i < text1.length(); i++) {
            for (int j = 0; j < text2.length(); j++) {
                if (text1.charAt(i) == text2.charAt(j)) {
                    dp[i + 1][j + 1] = dp[i][j] + 1;
                } else {
                    dp[i + 1][j + 1] = Math.max(dp[i + 1][j], dp[i][j + 1]);
                }
            }
        }
        return dp[dp.length - 1][dp[0].length - 1];
    }
}
