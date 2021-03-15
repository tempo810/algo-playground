package leetcode;

import java.util.Arrays;

/**
 * @author tempo
 */
public class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();
        Arrays.sort(sArr);
        Arrays.sort(tArr);
        return Arrays.equals(sArr, tArr);
    }


    public boolean isAnagramV2(String s, String t) {
        int[] counters = new int[26];
        for (char c : s.toCharArray()) {
            counters[c - 'a']++;
        }

        for (char c : t.toCharArray()) {
            counters[c - 'a']--;
        }

        for (int counter : counters) {
            if (counter != 0) {
                return false;
            }
        }

        return true;
    }
}
