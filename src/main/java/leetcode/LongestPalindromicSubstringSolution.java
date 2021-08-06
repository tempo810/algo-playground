package leetcode;

/**
 * @author Tempo
 */
public class LongestPalindromicSubstringSolution {
    public String longestPalindrome(String s) {
        int length = s.length();
        boolean[][] memo = new boolean[length][length];
        String subString = "";
        for (int i = 0; i < length; i++) {
            for (int start = 0; start + i < length; start++) {
                int end = start + i;
                if (start == end) {
                    memo[start][end] = true;
                } else if (s.charAt(start) == s.charAt(end)) {
                    memo[start][end] = start + 1 == end || memo[start + 1][end - 1];
                }

                if (memo[start][end]) {
                    subString = s.substring(start, end + 1);
                }
            }
        }
        return subString;
    }

    public String longestPalindromeV2(String s) {
        char[] chars = s.toCharArray();
        boolean[][] dp = new boolean[s.length()][s.length()];
        int startIndex = -1;
        int endIndex = -1;
        for (int i = 0; i < chars.length; i++) {
            for (int j = 0; j + i < chars.length; j++) {
                int end = j + i;
                if (i == end) {
                    dp[j][end] = true;
                } else if (chars[j] == chars[end]) {
                    dp[j][end] = i == 1 || dp[j + 1][end - 1];
                }

                if (dp[j][end]) {
                    startIndex = j;
                    endIndex = end;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = startIndex; i <= endIndex; i++) {
            sb.append(chars[i]);
        }
        return sb.toString();
    }
}
