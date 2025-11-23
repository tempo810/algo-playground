package leetcode.leetcode75;

/**
 * @author tempo
 */
public class MoveZeros {
    public void moveZeroes(int[] nums) {
        int writeCursor = 0;
        for (int num : nums) {
            if (num != 0) {
                nums[writeCursor++] = num;
            }
        }
        for (int i = writeCursor; i < nums.length; i++) {
            nums[i] = 0;
        }
    }
}
