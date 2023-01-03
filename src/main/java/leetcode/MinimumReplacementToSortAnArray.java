package leetcode;

/**
 * @author tempo
 */
public class MinimumReplacementToSortAnArray {
    public long minimumReplacement(int[] nums) {
        int minValue = nums[nums.length - 1];
        long count = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] <= minValue) {
                minValue = nums[i];
            } else {
                int dividend = nums[i] / minValue;
                int remainder = nums[i] % minValue;
                if (remainder == 0) {
                    dividend--;
                } else {
                    minValue = nums[i] / (dividend + 1);
                }
                count += dividend;
            }
        }
        return count;
    }
}
