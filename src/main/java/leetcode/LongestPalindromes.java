package leetcode;

/**
 * @author Tempo
 */
public class LongestPalindromes {
    public int longestPalindrome(String s) {
        int[] characterCounts = new int[52];
        for (char c : s.toCharArray()) {
            int index = Character.isUpperCase(c) ? c - 'A' : c - 'a' + 26;
            characterCounts[index]++;
        }
        int total = 0;
        for (int characterCount : characterCounts) {
            total += characterCount / 2 * 2;
            if (total % 2 == 0 && characterCount % 2 == 1) {
                total++;
            }
        }
        return total;
    }
}
