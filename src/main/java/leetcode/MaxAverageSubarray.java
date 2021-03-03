package leetcode;

/**
 * @author tempo
 */
public class MaxAverageSubarray {
    public double findMaxAverage(int[] nums, int k) {
        int globalMax = 0;
        int movingSum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i < k) {
                globalMax += nums[i];
                movingSum = globalMax;
            } else {
                movingSum = movingSum - nums[i - k] + nums[i];
                globalMax = Math.max(globalMax, movingSum);
            }
        }
        return (double) globalMax / k;
    }
}
