package leetcode.leetcode75;

import java.util.Arrays;

/**
 * @author tempo
 */
public class DetermineIfTwoStringsAreClosed {
    public boolean closeStrings(String word1, String word2) {
        if (word1.length() != word2.length()) {
            return false;
        }
        if (word1.equals(word2)) return true;

        int[] charsOccurrence1 = new int[26];
        int[] charsOccurrence2 = new int[26];
        for (int i = 0; i < word1.length(); i++) {
            charsOccurrence1[word1.charAt(i) - 'a']++;
            charsOccurrence2[word2.charAt(i) - 'a']++;
        }
        for (int i = 0; i < charsOccurrence1.length; i++) {
            if ((charsOccurrence1[i] == 0 && charsOccurrence2[i] != 0) || (charsOccurrence2[i] == 0 && charsOccurrence1[i] != 0)) {
                return false;
            }
        }

        Arrays.sort(charsOccurrence1);
        Arrays.sort(charsOccurrence2);
        return Arrays.equals(charsOccurrence1, charsOccurrence2);
    }
}
