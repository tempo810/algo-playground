package leetcode;

/**
 * @author tempo
 */
public class RotateArray {
    public void rotate(int[] nums, int k) {
        int step = k % nums.length;
        if (step == 0) {
            return;
        }

        for (int i = 0; i < nums.length / 2; i++) {
            int temp = nums[i];
            nums[i] = nums[nums.length - i - 1];
            nums[nums.length - i - 1] = temp;
        }

        for (int i = 0; i < step / 2; i++) {
            int temp = nums[i];
            nums[i] = nums[step - 1 - i];
            nums[step - 1 - i] = temp;
        }

        for (int i = 0; i < (nums.length - step) / 2; i++) {
            int temp = nums[step + i];
            nums[step + i] = nums[nums.length - i - 1];
            nums[nums.length - i - 1] = temp;
        }
    }
}
