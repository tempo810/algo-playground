package leetcode;

/**
 * @author tempo
 */
public class MinimizeMaximumOfArray {
    public int minimizeArrayValue(int[] nums) {
        long sum = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            max = Math.max(max, (int) Math.ceil((double) sum / (i + 1)));
        }
        return max;
    }
}
