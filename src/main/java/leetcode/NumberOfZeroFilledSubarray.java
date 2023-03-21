package leetcode;

/**
 * @author tempo
 */
public class NumberOfZeroFilledSubarray {
    public long zeroFilledSubarray(int[] nums) {
        long total = 0;
        int count = 0;
        for (int num : nums) {
            if (num == 0) {
                count++;
                total += count;
            } else {
                count = 0;
            }
        }
        return total;
    }
}
