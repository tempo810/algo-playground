package leetcode;

/**
 * @author Tempo
 */
public class BackspaceStringCompare {
    public boolean backspaceCompare(String s, String t) {
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();

        int sIndex = nextValid(sChars, sChars.length - 1);
        int tIndex = nextValid(tChars, tChars.length - 1);

        while (sIndex >= 0 && tIndex >= 0) {
            if (sChars[sIndex] != tChars[tIndex]) {
                return false;
            }
            sIndex = nextValid(sChars, sIndex - 1);
            tIndex = nextValid(tChars, tIndex - 1);
        }

        return sIndex == -1 && tIndex == -1;
    }

    private int nextValid(char[] chars, int index) {
        int backSpace = 0;
        int cursor = index;
        while (cursor >= 0 && (backSpace > 0 || chars[cursor] == '#')) {
            if (chars[cursor] == '#') {
                backSpace++;
            } else {
                backSpace--;
            }
            cursor--;
        }
        return cursor;
    }
}
