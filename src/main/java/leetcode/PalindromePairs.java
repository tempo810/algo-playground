package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Tempo
 */
public class PalindromePairs {
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> results = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if (isPalindrome(words[i], words[j])) {
                    results.add(List.of(i, j));
                }
                if (isPalindrome(words[j], words[i])) {
                    results.add(List.of(j, i));
                }
            }
        }
        return results;
    }

    private boolean isPalindrome(String word, String word1) {
        int end = word.length() + word1.length() - 1;
        int start = 0;
        while (start < end) {
            char startChar = start < word.length() ? word.charAt(start) : word1.charAt(start - word.length());
            char endChar = end < word.length() ? word.charAt(end) : word1.charAt(end - word.length());
            if (startChar != endChar) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
