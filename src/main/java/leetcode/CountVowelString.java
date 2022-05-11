package leetcode;

/**
 * @author Tempo
 */
public class CountVowelString {
    public int countVowelStringDp(int n) {
        if (n == 0) {
            return 0;
        }

        int[] dp = {1, 2, 3, 4, 5};

        for (int i = 1; i < n; i++) {
            int currentLengthCount = 0;
            for (int j = 0; j < dp.length; j++) {
                currentLengthCount += dp[j];
                dp[j] = currentLengthCount;
            }
        }
        return dp[4];
    }

    public int countVowelStrings(int n) {
        return countVowel(0, n);
    }

    private int countVowel(int index, int n) {
        if (n == 0) {
            return 1;
        }
        int number = 0;
        for (int i = index; i < 5; i++) {
            number += countVowel(i, n - 1);
        }
        return number;
    }
}
