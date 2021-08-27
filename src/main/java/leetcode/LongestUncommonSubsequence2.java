package leetcode;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Tempo
 */
public class LongestUncommonSubsequence2 {
    public int findLUSlength(String[] strs) {
        if (strs.length == 1) {
            return strs[0].length();
        }
        Arrays.sort(strs, Comparator.comparingInt(String::length).reversed());

        if (!strs[0].equals(strs[1])) {
            return strs[0].length();
        }

        for (int i = 2; i < strs.length; i++) {
            if (i + 1 < strs.length && strs[i].equals(strs[i + 1])) {
                i++;
                continue;
            }
            int j = 1;
            for (; j < i; j++) {
                if (contains(strs[i], strs[j])) {
                    break;
                }
            }
            if (j == i) {
                return strs[i].length();
            }
        }
        return -1;
    }

    private boolean contains(String s1, String s2) {
        int p1 = 0;
        int p2 = 0;
        while (p1 < s1.length() && p2 < s2.length()) {
            if (s1.charAt(p1) == s2.charAt(p2)) {
                p1++;
            }
            p2++;
        }
        return p1 == s1.length();
    }
}
