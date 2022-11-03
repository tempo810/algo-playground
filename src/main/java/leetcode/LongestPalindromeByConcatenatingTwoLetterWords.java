package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author tempo
 */
public class LongestPalindromeByConcatenatingTwoLetterWords {

    public int longestPalindrome(String[] words) {
        int length = 0;
        Map<String, Integer> expectedWords = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        boolean[] duplicatedCharacters = new boolean[26];
        for (String word : words) {
            if (word.charAt(0) == word.charAt(1)) {
                int index = word.charAt(0) - 'a';
                if (duplicatedCharacters[index]) {
                    length += 4;
                    duplicatedCharacters[index] = false;
                } else {
                    duplicatedCharacters[index] = true;
                }
            } else {
                Integer digit = expectedWords.get(word);
                if (digit != null && digit > 0) {
                    length += 4;
                    expectedWords.put(word, digit - 1);
                } else {
                    sb.append(word.charAt(1));
                    sb.append(word.charAt(0));
                    expectedWords.compute(sb.toString(), (key, value) -> value == null ? 1 : value + 1);
                    sb.setLength(0);
                }
            }
        }
        for (boolean b : duplicatedCharacters) {
            if (b) {
                length += 2;
                break;
            }
        }
        return length;
    }
}
