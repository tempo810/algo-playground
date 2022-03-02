package leetcode;

/**
 * @author Tempo
 */
public class IsSubsequence {
    public boolean isSubsequence(String s, String t) {
        if (s.length() == 0) return true;
        char[] tChars = t.toCharArray();
        int tIndex = 0;
        char[] sChars = s.toCharArray();
        int sIndex = 0;

        while (tIndex < tChars.length) {
            if (sChars[sIndex] == tChars[tIndex]) {
                sIndex++;
                if (sIndex == sChars.length) return true;
            }
            tIndex++;

        }
        return false;
    }
}
