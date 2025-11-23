package leetcode.leetcode75;

/**
 * @author tempo
 */
public class FindPivotIndex {

    public int pivotIndex(int[] nums) {
        int[] prefixSum = new int[nums.length];
        prefixSum[prefixSum.length - 1] = nums[nums.length - 1];
        for (int i = nums.length - 2; i >= 0; i--) {
            prefixSum[i] = prefixSum[i + 1] + nums[i];
        }
        int tmp = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (tmp == prefixSum[i + 1]) {
                return i;
            }
            tmp += nums[i];
        }
        return tmp == 0 ? nums.length - 1 : -1;
    }
}
