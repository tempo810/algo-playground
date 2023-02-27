package leetcode;

import java.util.Arrays;

/**
 * @author tempo
 */
public class EditDistance {
    public int minDistance(String word1, String word2) {
        int[][] dp = new int[word1.length()][word2.length()];
        for (int[] ints : dp) {
            Arrays.fill(ints, -1);
        }

        return findMin(0, word1.toCharArray(), 0, word2.toCharArray(), dp);
    }

    private int findMin(int word1Index, char[] word1, int word2Index, char[] word2, int[][] dp) {
        if (word2Index == word2.length) {
            return word1.length - word1Index;
        }
        if (word1Index == word1.length) {
            return word2.length - word2Index;
        }

        if (dp[word1Index][word2Index] == -1) {
            dp[word1Index][word2Index] = findMin(word1Index + 1, word1, word2Index + 1, word2, dp);
            if (word1[word1Index] != word2[word2Index]) {
                dp[word1Index][word2Index]++;
                int insert = findMin(word1Index, word1, word2Index + 1, word2, dp);
                int del = findMin(word1Index + 1, word1, word2Index, word2, dp);
                dp[word1Index][word2Index] = Math.min(dp[word1Index][word2Index], Math.min(insert, del) + 1);
            }
        }

        return dp[word1Index][word2Index];
    }
}
