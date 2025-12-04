package neetcode.blind75;

/**
 * @author tempo
 */
public class MissingNumber {
    public int missingNumber(int[] nums) {
        int total = 0;
        for (int i = 1; i <= nums.length; i++) {
            total += i;
        }
        for (int i = 0; i < nums.length; i++) {
            total -= nums[i];
        }
        return total;
    }
}
