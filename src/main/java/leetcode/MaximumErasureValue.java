package leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Tempo
 */
public class MaximumErasureValue {
    public int maximumUniqueSubarray(int[] nums) {
        Set<Integer> found = new HashSet<>();
        int left = 0;
        int right = 0;
        int sum = 0;
        int max = 0;
        while (left < nums.length && right < nums.length) {
            if (!found.contains(nums[right])) {
                found.add(nums[right]);
                sum += nums[right];
                max = Math.max(sum, max);
                right++;
            } else {
                sum -= nums[left];
                found.remove(nums[left]);
                left++;
            }
        }
        return max;
    }

    public int maximumUniqueSubarrayV2(int[] nums) {
        boolean[] found = new boolean[10001];
        int left = 0;
        int right = 0;
        int sum = 0;
        int max = 0;
        while (left < nums.length && right < nums.length) {
            if (!found[nums[right]]) {
                found[nums[right]] = true;
                sum += nums[right];
                max = Math.max(sum, max);
                right++;
            } else {
                sum -= nums[left];
                found[nums[left]] = false;
                left++;
            }
        }
        return max;
    }

    public int maximumUniqueSubarrayV3(int[] nums) {
        int[] prefixSums = new int[nums.length + 1];
        int[] seen = new int[10001];
        Arrays.fill(seen, -1);

        int maxErasure = 0;
        int start = 0;
        for (int i = 0; i < nums.length; i++) {
            prefixSums[i + 1] = prefixSums[i] + nums[i];
            if (seen[nums[i]] >= start) {
                start = seen[nums[i]] + 1;
            }
            seen[nums[i]] = i;
            maxErasure = Math.max(maxErasure, prefixSums[i + 1] - prefixSums[start]);
        }
        return maxErasure;
    }
}
