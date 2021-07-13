package leetcode;

import java.util.Arrays;

/**
 * @author Tempo
 */
public class IsomorphicString {
    public boolean isIsomorphic(String s, String t) {
        int[] firstHash = new int[128];
        int[] secondHash = new int[128];
        Arrays.fill(firstHash, -1);
        Arrays.fill(secondHash, -1);

        for (int i = 0; i < s.length(); i++) {
            char sChar = s.charAt(i);
            char tChar = t.charAt(i);
            if (firstHash[sChar] != secondHash[tChar]) {
                return false;
            }
            firstHash[sChar] = i;
            secondHash[tChar] = i;
        }
        return true;
    }
}
