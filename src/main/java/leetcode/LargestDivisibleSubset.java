package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * @author Tempo
 */
public class LargestDivisibleSubset {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        int subsetSize = findLargestSubsetSize(nums, dp);
        Stack<Integer> temp = new Stack<>();
        for (int i = nums.length - 1; i >= 0; i--) {
            if (dp[i] == subsetSize) {
                if (temp.isEmpty() || temp.peek() % nums[i] == 0) {
                    temp.push(nums[i]);
                    subsetSize--;
                }
            }
        }

        List<Integer> result = new ArrayList<>();
        while (!temp.isEmpty()) {
            result.add(temp.pop());
        }
        return result;
    }

    private int findLargestSubsetSize(int[] nums, int[] dp) {
        int largestSize = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    largestSize = Math.max(dp[i], largestSize);
                }
            }
        }
        return largestSize;
    }
}
