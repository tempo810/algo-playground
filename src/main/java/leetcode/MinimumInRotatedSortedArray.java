package leetcode;

/**
 * @author Tempo
 */
public class MinimumInRotatedSortedArray {
    public int findMin(int[] nums) {
        return find(nums, 0, nums.length - 1);
    }

    private int find(int[] nums, int start, int end) {
        if (start == end || nums[start] + (end - start) == nums[end]) {
            return nums[start];
        }
        int mid = (start + end) / 2;
        if (nums[mid] > nums[end]) {
            return find(nums, mid + 1, end);
        }
        return find(nums, start, mid);
    }
}
