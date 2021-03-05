package leetcode;

import java.util.Arrays;

/**
 * @author tempo
 */
public class NextPermutation {
    public void nextPermutation(int[] nums) {
        if (nums.length > 1) {
            for (int i = nums.length - 1; i > 0; i--) {
                if (nums[i] > nums[i - 1]) {
                    Arrays.sort(nums, i, nums.length);
                    for (int j = i; j < nums.length; j++) {
                        if (nums[j] > nums[i - 1]) {
                            nums[j] += nums[i - 1];
                            nums[i - 1] = nums[j] - nums[i - 1];
                            nums[j] -= nums[i - 1];
                            return;
                        }
                    }
                }
            }
            Arrays.sort(nums);
        }
    }
}
