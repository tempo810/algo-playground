package leetcode.leetcode75;

/**
 * @author tempo
 */
public class IsSubsequence {
    public boolean isSubsequence(String s, String t) {
        int sCursor = 0;
        int tCursor = 0;
        while (sCursor < s.length() && tCursor < t.length()) {
            if (s.charAt(sCursor) == t.charAt(tCursor)) {
                sCursor++;
            }
            tCursor++;
        }
        return sCursor == s.length();
    }
}
