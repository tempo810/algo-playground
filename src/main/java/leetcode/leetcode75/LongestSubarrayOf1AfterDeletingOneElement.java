package leetcode.leetcode75;

/**
 * @author tempo
 */
public class LongestSubarrayOf1AfterDeletingOneElement {
    public int longestSubarray(int[] nums) {
        int lastDel = -1;
        int longestSubarray = 0;
        int tmp = 0;
        for (int i = 0; i < nums.length; i++) {
            tmp++;
            if (nums[i] != 1) {
                if (lastDel != -1) {
                    int newStartPos = lastDel + 1;
                    tmp = i - newStartPos;
                }
                lastDel = i;
            }
            longestSubarray = Math.max(tmp, longestSubarray);
        }
        return longestSubarray;
    }
}
