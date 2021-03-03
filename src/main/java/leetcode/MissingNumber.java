package leetcode;

/**
 * @author Tempo
 */
public class MissingNumber {
    public int missingNumber(int[] nums) {
        int missing = 0;
        for (int i = 0; i < nums.length; i++) {
            missing += i + 1 - nums[i];
        }
        return missing;
    }
}
