package leetcode;

import java.util.Set;

/**
 * @author tempo
 */
public class StringHalvesAlike {
    private static final Set<Character> VOWELS = Set.of('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U');

    public boolean halvesAreAlike(String s) {
        int vowelCount = 0;
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length / 2; i++) {
            if (VOWELS.contains(chars[i])) {
                vowelCount++;
            }
        }
        for (int i = chars.length / 2; i < chars.length; i++) {
            if (VOWELS.contains(chars[i])) {
                vowelCount--;
            }
        }
        return vowelCount == 0;
    }
}
