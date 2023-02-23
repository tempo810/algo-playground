package leetcode;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author tempo
 */
public class MaxSubsequenceScore {
    public long maxScore(int[] nums1, int[] nums2, int k) {
        int[] score = nums1;
        int[] multiplier = nums2;
        int[][] entries = new int[nums1.length][2];
        for (int i = 0; i < nums1.length; i++) {
            entries[i][0] = score[i];
            entries[i][1] = multiplier[i];
        }
        Arrays.sort(entries, (a, b) -> b[1] - a[1]);
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        long result = 0;
        long heapSum = 0;
        for (int[] entry : entries) {
            minHeap.add(entry[0]);
            heapSum += entry[0];
            if (minHeap.size() > k) {
                heapSum -= minHeap.poll();
            }

            if (minHeap.size() == k) {
                result = Math.max(result, heapSum * entry[1]);
            }
        }

        return result;
    }

}
