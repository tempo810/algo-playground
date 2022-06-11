package leetcode;

/**
 * @author Tempo
 */
public class MinOperationToReduceXToZero {
    public int minOperations(int[] nums, int x) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        // handle edge cases
        if (sum == x) return nums.length;
        if (sum < x) return -1;

        int current = 0;
        int start = 0;
        int maxLength = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            current += nums[i];
            while (sum - x < current && start <= i) {
                current -= nums[start];
                start++;
            }
            if (sum - x == current) {
                maxLength = Math.max(maxLength, i - start + 1);
            }
        }
        return maxLength == Integer.MIN_VALUE ? -1 : nums.length - maxLength;
    }
}
