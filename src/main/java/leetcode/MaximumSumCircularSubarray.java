package leetcode;

/**
 * @author tempo
 */
public class MaximumSumCircularSubarray {
    public int maxSubarraySumCircular(int[] nums) {
        int currentMin = 0;
        int globalMin = 0;
        int total = 0;
        int maxValue = Integer.MIN_VALUE;

        int currentMax = 0;
        int globalMax = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            maxValue = Math.max(maxValue, nums[i]);
            total += nums[i];
            currentMin += nums[i];
            if (currentMin > 0) {
                currentMin = 0;
            }
            globalMin = Math.min(globalMin, currentMin);

            currentMax += nums[i];
            if (currentMax < 0) {
                currentMax = 0;
            }
            globalMax = Math.max(globalMax, currentMax);
        }
        if (maxValue < 0) {
            return maxValue;
        }
        return Math.max(total - globalMin, globalMax);
    }
}
