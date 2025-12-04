package leetcode.top;

import java.util.Arrays;

/**
 * @author tempo
 */
public class LongestSubstringWithoutRepeatingCharacter {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() <= 1) {
            return s.length();
        }
        int max = 0;
        int currentSubstringStart = 0;
        int[] chars = new int[128];
        Arrays.fill(chars, -1);
        for (int i = 0; i < s.length(); i++) {
            final char currentChar = s.charAt(i);
            // duplicate character detected
            if (chars[currentChar] >= currentSubstringStart) {
                currentSubstringStart = chars[currentChar] + 1;
            }
            chars[currentChar] = i;
            max = Math.max(max, i - currentSubstringStart + 1);
        }
        return max;
    }
}
