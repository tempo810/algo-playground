package leetcode.top;

/**
 * @author tempo
 */
public class SearchInRotatedSortedArray {
    public int search(int[] nums, int target) {
        if (nums.length == 1) {
            return nums[0] == target ? 0 : -1;
        }
        int index = this.findLowest(nums);
        if (index > 0) {
            if (target >= nums[0] && target <= nums[index - 1]) {
                return this.search(nums, target, 0, index - 1);
            }
        }
        return this.search(nums, target, index, nums.length - 1);
    }

    private int search(int[] nums, int target, int start, int end) {
        int left = start;
        int right = end;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    private int findLowest(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[nums.length - 1]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }
}
