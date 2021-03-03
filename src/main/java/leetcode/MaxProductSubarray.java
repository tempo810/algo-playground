package leetcode;

/**
 * @author tempo
 */
public class MaxProductSubarray {
    public int maxProduct(int[] nums) {
        int running = nums[0];
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            running = running == 0 ? nums[i] : running * nums[i];
            max = Math.max(max, running);
            max = Math.max(max, nums[i]);
        }

        running = nums[nums.length - 1];
        for (int i = nums.length - 2; i >= 0; i--) {
            running = running == 0 ? nums[i] : running * nums[i];
            max = Math.max(max, running);
        }

        return max;
    }
}
