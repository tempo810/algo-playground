package leetcode.leetcode75;

/**
 * @author tempo
 */
public class MaximumAverageSubarray1 {
    public double findMaxAverage(int[] nums, int k) {
        int temp = 0;
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            temp += nums[i];
            if (i >= k - 1) {
                maxSum = Math.max(temp, maxSum);
                temp -= nums[i - k + 1];
            }
        }
        return (double) maxSum / k;
    }
}
