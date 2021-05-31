package leetcode;

import java.util.Arrays;

/**
 * @author Tempo
 */
public class MaximumGap {
    public int maximumGap(int[] nums) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int num : nums) {
            max = Math.max(num, max);
            min = Math.min(num, min);
        }

        int interval = (int) Math.ceil((double) (max - min) / (nums.length - 1));
        int[] minBucket = new int[nums.length];
        int[] maxBucket = new int[nums.length];
        Arrays.fill(minBucket, Integer.MAX_VALUE);
        Arrays.fill(maxBucket, Integer.MIN_VALUE);

        for (int num : nums) {
            if (num > min && num < max) {
                int index = (num - min) / interval;
                minBucket[index] = Math.min(minBucket[index], num);
                maxBucket[index] = Math.max(maxBucket[index], num);
            }
        }

        int maxGap = Integer.MIN_VALUE;
        int previous = min;
        for (int i = 0; i < nums.length - 1; i++) {
            if (minBucket[i] < Integer.MAX_VALUE && maxBucket[i] > Integer.MIN_VALUE) {
                maxGap = Math.max(maxGap, minBucket[i] - previous);
                previous = maxBucket[i];
            }
        }
        maxGap = Math.max(maxGap, max - previous);
        return maxGap;

    }
}
