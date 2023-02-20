package leetcode;

/**
 * @author tempo
 */
public class SearchInsertPosition {
    public int searchInsert(int[] nums, int target) {
        int hi = nums.length - 1;
        int lo = 0;
        while (hi >= lo) {
            int mid = (hi + lo) / 2;
            if (target == nums[mid]) {
                return mid;
            }
            if (target > nums[mid]) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return hi + 1;
    }
}
