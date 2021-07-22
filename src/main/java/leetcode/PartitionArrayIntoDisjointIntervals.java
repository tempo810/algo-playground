package leetcode;

/**
 * @author Tempo
 */
public class PartitionArrayIntoDisjointIntervals {
    // kadane's
    public int partitionDisjoint(int[] nums) {
        int leftMax = nums[0];
        int currentMax = nums[0];
        int disjointIndex = Integer.MIN_VALUE;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < leftMax) {
                leftMax = Math.max(leftMax, currentMax);
                disjointIndex = i;
                currentMax = nums[i];
            } else {
                currentMax = Math.max(currentMax, nums[i]);
            }
        }
        return disjointIndex == Integer.MIN_VALUE ? 1 : disjointIndex + 1;
    }
}
