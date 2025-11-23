package leetcode.leetcode75;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author tempo
 */
public class MaximumSubsequenceScore {
    public long maxScore(int[] nums1, int[] nums2, int k) {
        int[][] multipliers = new int[nums2.length][2];
        for (int i = 0; i < nums2.length; i++) {
            multipliers[i] = new int[]{nums2[i], nums1[i]};
        }
        Arrays.sort(multipliers, (a, b) -> Integer.compare(b[0], a[0]));
        long currentSum = 0;
        long maxSum = Long.MIN_VALUE;
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(Comparator.naturalOrder());
        for (int i = 0; i < multipliers.length; i++) {
            final int[] currentMultiplier = multipliers[i];
            final int currentScore = currentMultiplier[1];
            minHeap.add(currentScore);
            currentSum += currentScore;
            if (minHeap.size() == k) {
                maxSum = Math.max(maxSum, currentSum * currentMultiplier[0]);
                currentSum -= minHeap.poll();
            }
        }
        return maxSum;
    }
}
