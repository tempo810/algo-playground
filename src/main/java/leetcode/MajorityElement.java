package leetcode;

import java.util.Arrays;

/**
 * @author tempo
 */
public class MajorityElement {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }
}
