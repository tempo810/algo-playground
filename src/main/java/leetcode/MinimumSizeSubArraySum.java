package leetcode;

/**
 * @author Tempo
 */
public class MinimumSizeSubArraySum {
    public int minSubArrayLen(int target, int[] nums) {
        int sum = 0;
        int startIndex = 0;
        int minLength = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            while (sum >= target) {
                sum -= nums[startIndex];
                minLength = Math.min(minLength, i - startIndex + 1);
                startIndex++;
            }
        }
        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }
}
