package leetcode.leetcode75;

/**
 * @author tempo
 */
public class MaximumNumberOfVowelsInASubstringOfGivenLength {
    public int maxVowels(String s, int k) {
        int currentVowelCount = 0;
        int maxVowelCount = 0;
        for (int i = 0; i < s.length(); i++) {
            if (isVowel(s.charAt(i))) {
                currentVowelCount++;
            }

            if (i >= k && isVowel(s.charAt(i - k))) {
                currentVowelCount--;
            }

            maxVowelCount = Math.max(currentVowelCount, maxVowelCount);
            if (maxVowelCount == k) {
                return k;
            }
        }
        return maxVowelCount;
    }

    private boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}
