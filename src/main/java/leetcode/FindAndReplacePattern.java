package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Tempo
 */
public class FindAndReplacePattern {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        int[] targetPattern = new int[pattern.length()];
        int[] temp = new int[26];
        Arrays.fill(temp, -1);
        int unique = 0;
        for (int i = 0; i < pattern.length(); i++) {
            int charIndex = pattern.charAt(i) - 'a';
            if (temp[charIndex] == -1) {
                temp[charIndex] = unique++;
            }
            targetPattern[i] = temp[charIndex];
        }
        List<String> result = new ArrayList<>();
        for (String word : words) {
            Arrays.fill(temp, -1);
            boolean isAnagram = true;
            unique = 0;
            for (int i = 0; i < word.length() && isAnagram; i++) {
                int charIndex = word.charAt(i) - 'a';
                if (temp[charIndex] == -1) {
                    temp[charIndex] = unique++;
                }
                isAnagram = targetPattern[i] == temp[charIndex];
            }
            if (isAnagram) {
                result.add(word);
            }
        }
        return result;
    }
}
