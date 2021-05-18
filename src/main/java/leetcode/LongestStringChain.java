package leetcode;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Tempo
 */
public class LongestStringChain {
    public int longestStrChain(String[] words) {
        Arrays.sort(words, Comparator.comparingInt(String::length));
        int[] dp = new int[words.length];
        Arrays.fill(dp, 1);
        int result = 1;
        for (int i = 1; i < words.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (words[i].length() == words[j].length()) {
                    continue;
                }
                if (words[j].length() + 1 < words[i].length()) {
                    break;
                }
                if (isChain(words[j], words[i])) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            result = Math.max(dp[i], result);
        }
        return result;
    }

    private boolean isChain(String shortString, String longString) {
        int i = 0;
        int j = 0;
        while (i < shortString.length() && j < longString.length()) {
            if (shortString.charAt(i) == longString.charAt(j)) {
                i++;
                j++;
            } else {
                j++;
            }
        }
        return i == shortString.length();
    }
}
