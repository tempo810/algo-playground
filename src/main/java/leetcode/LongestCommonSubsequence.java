package leetcode;

/**
 * @author Tempo
 */
public class LongestCommonSubsequence {
    public int longestCommonSubsequence(String text1, String text2) {
        int[][] dp = new int[text1.length() + 1][text2.length() + 1];
        char[] chars1 = text1.toCharArray();
        char[] chars2 = text2.toCharArray();
        for (int i = 0; i < chars1.length; i++) {
            for (int j = 0; j < chars2.length; j++) {
                dp[i + 1][j + 1] = Math.max(dp[i][j + 1], dp[i + 1][j]);
                if (chars1[i] == chars2[j]) {
                    dp[i + 1][j + 1] = dp[i][j] + 1;
                }
            }
        }
        return dp[dp.length - 1][dp[0].length - 1];
    }
}
