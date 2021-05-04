package leetcode;

/**
 * @author Tempo
 */
public class NonDecreasingArray {
    public boolean checkPossibility(int[] nums) {
        boolean modified = false;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1]) {
                if (modified) {
                    return false;
                } else {
                    boolean isPeak = i + 1 >= nums.length || nums[i - 1] <= nums[i + 1];
                    boolean isBottom = i - 2 < 0 || nums[i - 2] <= nums[i];
                    if (!isPeak && !isBottom) {
                        return false;
                    }
                    modified = true;
                }
            }
        }
        return true;
    }
}
