package leetcode;

/**
 * @author Tempo
 */
public class MinimumSwap {
    public int minSwaps(String s) {
        int opening = 0;
        int closing = 0;

        int start = 0;
        int end = s.length() - 1;

        int swap = 0;
        while (start < end) {
            if (s.charAt(start) == '[') {
                opening++;
            } else {
                closing++;
            }
            if (closing > opening) {
                while (s.charAt(end) != '[') {
                    end--;
                }
                closing--;
                opening++;
                swap++;
            }
            start++;
        }
        return swap;
    }
}
