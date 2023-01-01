package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author tempo
 */
public class WordPattern {
    public boolean wordPattern(String pattern, String s) {
        String[] patternHash = new String[26];
        Set<String> seen = new HashSet<>();

        StringBuilder sb = new StringBuilder();
        int patternIndex = 0;
        for (char c : s.toCharArray()) {
            if (c != ' ') {
                sb.append(c);
            } else {
                if (!compare(sb.toString(), patternHash, pattern, patternIndex, seen)) {
                    return false;
                }
                sb.setLength(0);
                patternIndex++;
            }
        }
        return patternIndex + 1 == pattern.length() && compare(sb.toString(), patternHash, pattern, patternIndex, seen);
    }

    private boolean compare(String word, String[] patternHash, String pattern, int patternIndex, Set<String> seen) {
        if (patternIndex == pattern.length()) {
            return false;
        }
        int hashPosition = pattern.charAt(patternIndex) - 'a';
        if (patternHash[hashPosition] == null) {
            if (!seen.add(word)) {
                return false;
            }
            patternHash[hashPosition] = word;
            return true;
        }
        return word.equals(patternHash[hashPosition]);
    }
}
