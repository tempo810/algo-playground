package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Tempo
 */
public class MinimumDeletionsToMakeCharacterFrequenciesUnique {
    public int minDeletions(String s) {
        int[] chars = new int[26];
        for (char c : s.toCharArray()) {
            chars[c - 'a']++;
        }
        Set<Integer> seen = new HashSet<>();
        int delete = 0;
        for (int aChar : chars) {
            int j = aChar;
            if (j > 0) {
                while (j > 0 && !seen.add(j)) {
                    j--;
                }
                delete += aChar - j;
            }
        }
        return delete;
    }
}
