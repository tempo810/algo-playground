package leetcode;

import java.util.Arrays;

/**
 * @author Tempo
 */
public class KDiffPairsInAnArray {
    public int findPairs(int[] nums, int k) {
        Arrays.sort(nums);
        int pairs = 0;
        int l = 0, r = 0;
        while (r < nums.length) {
            if (l == r) {
                r = findNextValueIndex(nums, r);
            } else {
                int diff = nums[r] - nums[l];
                if (diff == k) {
                    pairs++;
                    l = findNextValueIndex(nums, l);
                    r = findNextValueIndex(nums, r);
                } else if (diff > k) {
                    l = findNextValueIndex(nums, l);
                } else {
                    r = findNextValueIndex(nums, r);
                }
            }
        }
        return pairs;
    }

    private int findNextValueIndex(int[] nums, int index) {
        for (int i = index + 1; i < nums.length; i++) {
            if (nums[i] > nums[index]) {
                return i;
            }
        }
        return Integer.MAX_VALUE;
    }
}
