package leetcode;

/**
 * @author tempo
 */
public class LengthOfIncreasingSubsequence {
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length + 1];
        int result = 0;
        for (int num : nums) {
            int left = 0;
            int right = result;
            while (left != right) {
                int mid = (left + right) / 2 + 1;
                if (dp[mid] < num) {
                    left = mid;
                } else {
                    right = mid - 1;
                }
            }
            dp[left + 1] = num;
            result = Math.max(left + 1, result);
        }
        return result;
    }
}
