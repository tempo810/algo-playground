package leetcode;

import java.util.Arrays;

/**
 * @author tempo
 */
public class LongestSubstringWithoutRepeatingCharacter {
    public int lengthOfLongestSubstring(String s) {
        int[] seen = new int[128];
        Arrays.fill(seen, -1);
        int max = 0;
        int start = 0;
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (seen[chars[i]] >= start) {
                start = seen[chars[i]] + 1;
            }
            seen[chars[i]] = i;
            max = Math.max(max, i - start + 1);
        }

        return max;
    }
}
