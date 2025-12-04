package leetcode.top;

/**
 * @author tempo
 */
public class SearchForARange {
    public int[] searchRange(int[] nums, int target) {
        int lowerBound = this.searchLowerBound(nums, target);
        if (lowerBound < 0 || lowerBound >= nums.length || nums[lowerBound] != target) {
            return new int[]{-1, -1};
        }
        int upperBound = this.searchUpperBound(nums, target);
        return new int[]{lowerBound, upperBound};
    }

    private int searchUpperBound(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return right;
    }

    private int searchLowerBound(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] >= target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
