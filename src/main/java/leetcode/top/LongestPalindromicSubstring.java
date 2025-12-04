package leetcode.top;

/**
 * @author tempo
 */
public class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        if (s.length() == 1) {
            return s;
        }
        boolean[][] dp = new boolean[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) {
            dp[i][i] = true; // start , end same;
        }

        int substringStart = 0;
        int substringLength = 1;
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                dp[i][i + 1] = true;
                substringStart = i;
                substringLength = 2;
            }
        }

        for (int length = 3; length <= s.length() && substringLength >= length - 2; length++) {
            for (int i = 0; i < s.length() - length; i++) {
                int end = i + length - 1;
                if (dp[i + 1][end - 1] && s.charAt(i) == s.charAt(end)) {
                    dp[i][end] = true;
                    substringStart = i;
                    substringLength = length;
                }
            }
        }

        return s.substring(substringStart, substringStart + substringLength);
    }
}
