package leetcode.leetcode75;

/**
 * @author tempo
 */
public class GuessNumberHigherOrLower {

    public int guessNumber(int n) {
        int hi = Integer.MAX_VALUE;
        int lo = 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            int result = guess(mid);
            if (result == -1) {
                hi = mid - 1;
            } else if (result == 1) {
                lo = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    private int guess(int mid) {
        return 0;
    }
}
