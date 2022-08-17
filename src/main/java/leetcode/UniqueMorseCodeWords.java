package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author tempo
 */
public class UniqueMorseCodeWords {
    private final String[] CODES = new String[]{".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."};

    public int uniqueMorseRepresentations(String[] words) {

        Set<String> seen = new HashSet<>();
        for (String word : words) {
            StringBuilder sb = new StringBuilder();
            for (char c : word.toCharArray()) {
                sb.append(CODES[c - 'a']);
            }
            seen.add(sb.toString());
        }
        return seen.size();
    }
}
