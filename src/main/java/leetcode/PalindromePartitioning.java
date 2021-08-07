package leetcode;

import java.util.Arrays;

/**
 * @author Tempo
 */
public class PalindromePartitioning {
    public int minCut(String s) {
        int[] dp = new int[s.length()];
        Arrays.fill(dp, -1);
        return dfs(0, s, dp) - 1;
    }

    private int dfs(int start, String s, int[] dp) {
        if (start == s.length()) {
            return 0;
        }
        if (dp[start] == -1) {
            int result = Integer.MAX_VALUE;
            for (int end = start; end < s.length(); end++) {
                if (isPalindrome(s, start, end)) {
                    result = Math.min(result, dfs(end + 1, s, dp) + 1);
                }
            }
            dp[start] = result;
        }
        return dp[start];
    }

    private boolean isPalindrome(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start) == s.charAt(end)) {
                start++;
                end--;
            } else {
                return false;
            }
        }
        return true;
    }
}
