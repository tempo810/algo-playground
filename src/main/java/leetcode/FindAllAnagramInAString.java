package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author tempo
 */
public class FindAllAnagramInAString {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> resList = new ArrayList<>();

        if (s == null || p == null || p.length() > s.length()) return resList;

        int[] sArr = new int[26];
        int[] pArr = new int[26];
        for (char ch : p.toCharArray()) {
            pArr[ch - 'a']++;
        }

        final char[] sChars = s.toCharArray();
        for (int i = 0; i < p.length(); i++) {
            sArr[sChars[i] - 'a']++;
        }

        if (Arrays.equals(sArr, pArr)) {
            resList.add(0);
        }

        for (int i = p.length(); i < s.length(); i++) {
            sArr[sChars[i - p.length()] - 'a']--;
            sArr[sChars[i] - 'a']++;

            if (Arrays.equals(sArr, pArr)) {
                resList.add(i - p.length() + 1);
            }
        }

        return resList;
    }
}
