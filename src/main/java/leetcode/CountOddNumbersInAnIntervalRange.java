package leetcode;

/**
 * @author tempo
 */
public class CountOddNumbersInAnIntervalRange {
    public int countOdds(int low, int high) {
        int diff = high - low;
        int count = diff / 2;
        if (diff % 2 != 0 || (low % 2 == 1 && high % 2 == 1)) {
            count++;
        }
        return count;
    }
}
