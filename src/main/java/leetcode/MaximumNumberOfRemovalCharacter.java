package leetcode;

/**
 * @author Tempo
 */
public class MaximumNumberOfRemovalCharacter {
    public int maximumRemovals(String s, String p, int[] removable) {
        char[] chars = s.toCharArray();
        int lo = 0;
        int hi = removable.length;
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            for (int i = 0; i < mid; i++) {
                chars[removable[i]] = '/';
            }
            if (valid(chars, p)) {
                lo = mid + 1;
            } else {
                for (int i = 0; i < mid; i++) {
                    chars[removable[i]] = s.charAt(removable[i]);
                }
                hi = mid - 1;
            }
        }
        return hi;
    }

    private boolean valid(char[] chars, String p) {
        int pCursor = 0;
        int charCursor = 0;
        while (pCursor < p.length() && charCursor < chars.length) {
            if (chars[charCursor] == p.charAt(pCursor)) {
                pCursor++;
            }
            charCursor++;
        }
        return pCursor == p.length();
    }
}
