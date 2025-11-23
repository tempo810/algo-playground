package leetcode.leetcode75;

/**
 * @author tempo
 */
public class FIndPeakElement {
    public int findPeakElement(int[] nums) {
        if (nums.length == 1 || nums[0] > nums[1]) {
            return 0;
        }
        if (nums[nums.length - 1] > nums[nums.length - 2]) {
            return nums.length - 1;
        }

        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int currentValue = nums[mid];
            if (currentValue > nums[mid + 1] && currentValue > nums[mid - 1]) {
                return mid;
            } else if (currentValue > nums[mid + 1]) {
                right = mid;
            } else {
                left = mid;
            }
        }
        return -1;
    }
}
