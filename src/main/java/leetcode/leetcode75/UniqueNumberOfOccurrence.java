package leetcode.leetcode75;

/**
 * @author tempo
 */
public class UniqueNumberOfOccurrence {
    public boolean uniqueOccurrences(int[] arr) {
        int offset = 1000;
        int[] sameDigitOccurrence = new int[2001];
        for (int digit : arr) {
            sameDigitOccurrence[digit + offset]++;
        }
        boolean[] seen = new boolean[arr.length + 1];
        for (int digit : sameDigitOccurrence) {
            if (seen[digit]) {
                return false;
            }
            seen[digit] = true;
        }
        return true;
    }
}
