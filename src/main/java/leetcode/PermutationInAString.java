package leetcode;

import java.util.Arrays;

/**
 * @author Tempo
 */
public class PermutationInAString {
    public boolean checkInclusion(String s1, String s2) {
        int[] s1Hash = new int[26];
        for (char c : s1.toCharArray()) {
            s1Hash[c - 'a']++;
        }
        int len = s1.length();
        char[] s2Array = s2.toCharArray();
        int[] s2Hash = new int[26];
        for (int i = 0; i < s2Array.length; i++) {
            s2Hash[s2Array[i] - 'a']++;
            if (i >= len - 1) {
                if (Arrays.equals(s1Hash, s2Hash)) {
                    return true;
                }
                s2Hash[s2Array[i - len + 1] - 'a']--;
            }
        }
        return false;
    }
}
