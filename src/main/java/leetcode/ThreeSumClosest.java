package leetcode;

import java.util.Arrays;

/**
 * @author Tempo
 */
public class ThreeSumClosest {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int remaining = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                int currentRemaining = findClosest(nums, target - nums[i] - nums[j], j + 1, nums.length - 1);
                if (Math.abs(currentRemaining) < Math.abs(remaining)) {
                    remaining = currentRemaining;
                }
            }
        }
        return target - remaining;
    }

    public int threeSumClosestV2(int[] nums, int target) {
        Arrays.sort(nums);
        int optimalDiff = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int currentDiff = target - (nums[i] + nums[left] + nums[right]);
                if (Math.abs(optimalDiff) > Math.abs(currentDiff)) {
                    optimalDiff = currentDiff;
                }
                if (currentDiff == 0) {
                    break;
                }
                if (currentDiff > 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return (optimalDiff - target) * -1;
    }

    private int findClosest(int[] nums, int remaining, int left, int right) {
        int diff = Integer.MAX_VALUE;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (Math.abs(remaining - nums[mid]) < Math.abs(diff)) {
                diff = remaining - nums[mid];
            }
            if (remaining < nums[mid]) {
                right = mid - 1;
            } else if (remaining > nums[mid]) {
                left = mid + 1;
            } else {
                break;
            }
        }
        return diff;
    }
}
