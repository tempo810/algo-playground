package leetcode;

/**
 * @author tempo
 */
public class CountSubarray {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        int minBound = -1;
        int maxBound = -1;
        int left = -1;
        long result = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < minK || nums[i] > maxK) {
                minBound = -1;
                maxBound = -1;
                left = i;
            } else {
                if (nums[i] == minK) {
                    minBound = i;
                }
                if (nums[i] == maxK) {
                    maxBound = i;
                }

                result += Math.max(0, Math.min(minBound, maxBound) - left);
            }
        }
        return result;
    }
}
