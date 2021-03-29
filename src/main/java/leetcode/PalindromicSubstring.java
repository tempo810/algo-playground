package leetcode;

/**
 * @author Tempo
 */
public class PalindromicSubstring {
    public int countSubstrings(String s) {
        int count = 0;
        boolean[][] dp = new boolean[s.length()][s.length()];
        int[] counts = new int[2];
        char[] chars = s.toCharArray();
        for (int length = 0; length < chars.length; length++) {
            counts[length % 2] = 0;
            for (int start = 0; start + length < chars.length; start++) {
                int end = length + start;
                if (start == end) {
                    dp[start][end] = true;
                } else if (chars[start] == chars[end]) {
                    dp[start][end] = length == 1 || dp[start + 1][end - 1];
                }
                if (dp[start][end]) {
                    counts[length % 2]++;
                }
            }
            count += counts[length % 2];
            if (counts[0] + counts[1] == 0) {
                break;
            }
        }

        return count;
    }
}
