package leetcode;

/**
 * @author Tempo
 */
public class CountBinaryString {
    public int countBinarySubstrings(String s) {
        int prev = 0;
        int current = 1;
        int result = 0;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                current++;
            } else {
                result += Math.min(prev, current);
                prev = current;
                current = 1;
            }
        }
        return result + Math.min(prev, current);
    }
}
