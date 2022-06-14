package leetcode;

/**
 * @author Tempo
 */
public class DeleteOperationForTwoStrings {
    public int minDistance(String word1, String word2) {
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];
        char[] firstWord = word1.toCharArray();
        char[] secondWord = word2.toCharArray();
        for (int i = 0; i < firstWord.length; i++) {
            for (int j = 0; j < secondWord.length; j++) {
                if (firstWord[i] == secondWord[j]) {
                    dp[i + 1][j + 1] = dp[i][j] + 1;
                } else {
                    dp[i + 1][j + 1] = Math.max(dp[i][j + 1], dp[i + 1][j]);
                }
            }
        }
        int lcs = dp[dp.length - 1][dp[0].length - 1];
        return firstWord.length - lcs + secondWord.length - lcs;
    }
}
