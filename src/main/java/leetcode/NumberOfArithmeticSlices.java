package leetcode;

/**
 * @author Tempo
 */
public class NumberOfArithmeticSlices {
    public int numberOfArithmeticSlices(int[] nums) {
        if (nums.length < 3) {
            return 0;
        }
        int count = 0;
        int consecutive = 0;
        for (int i = 2; i < nums.length; i++) {
            if (nums[i] - nums[i - 1] == nums[i - 1] - nums[i - 2]) {
                consecutive++;
                if (consecutive >= 1) {
                    count += consecutive;
                }
            } else {
                consecutive = 0;
            }
        }
        return count;
    }
}
