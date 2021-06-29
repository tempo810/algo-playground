package leetcode;

/**
 * @author Tempo
 */
public class MaxConsecutiveOne3 {
    public int longestOnes(int[] nums, int k) {
        int numberOfZero = 0;
        int start = 0;
        int end = 0;
        int maxLength = 0;
        while (end < nums.length) {
            if (nums[end] == 0) {
                if (numberOfZero < k) {
                    numberOfZero++;
                } else {
                    while (start < end && nums[start] != 0) {
                        start++;
                    }
                    start++;
                }
            }
            end++;
            maxLength = Math.max(maxLength, end - start);
        }
        return maxLength;
    }
}
