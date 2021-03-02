package leetcode;

/**
 * @author Tempo
 */
public class MaxSubArray {
    public int maxSubArray(int[] nums) {
        int globalMax = nums[0];
        int currentMax = nums[0];

        for (int i = 1; i < nums.length; i++) {
            currentMax = Math.max(currentMax, 0) + nums[i];
            globalMax = Math.max(globalMax, currentMax);
        }
        return globalMax;
    }
}
