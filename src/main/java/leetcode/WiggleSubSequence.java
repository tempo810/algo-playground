package leetcode;

/**
 * @author tempo
 */
public class WiggleSubSequence {
    public int wiggleMaxLength(int[] nums) {
        int up = 0;
        int down = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                down = up + 1;
            } else if (nums[i - 1] > nums[i]) {
                up = down + 1;
            }
        }
        return Math.max(up, down) + 1;
    }
}
