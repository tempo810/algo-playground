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
}
