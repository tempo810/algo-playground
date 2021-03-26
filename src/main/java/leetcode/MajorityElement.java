package leetcode;

import java.util.Arrays;

/**
 * @author tempo
 */
public class MajorityElement {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        int count = 1;
        int currentNum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == currentNum) {
                count++;
            } else {
                currentNum = nums[i];
                count = 1;
            }
            if (count >= Math.ceil((float) nums.length / 2)) {
                break;
            }
        }
        return currentNum;
    }
}
