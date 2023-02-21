package leetcode;

/**
 * @author tempo
 */
public class SingleElementInSortedArray {
    public int singleNonDuplicate(int[] nums) {
        int hi = nums.length - 1;
        int lo = 0;
        while (hi > lo) {
            int mid = (hi + lo) / 2;
            int targetValue = nums[mid];
            if (nums[mid - 1] == targetValue) {
                // 0, 1, 2, 3, 4, 5 (mid)
                if ((mid - 1 - lo) % 2 == 0) {
                    lo = mid + 1;
                } else {
                    hi = mid - 2;
                }
            } else if (nums[mid + 1] == targetValue) {
                // 5(mid), 6, 7, 8, 9 , 10
                if ((hi - (mid + 1)) % 2 == 0) {
                    hi = mid - 1;
                } else {
                    lo = mid + 2;
                }
            } else {
                return targetValue;
            }
        }
        return nums[hi];
    }
}
