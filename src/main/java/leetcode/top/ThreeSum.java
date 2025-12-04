package leetcode.top;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author tempo
 */
public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < nums.length - 1; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                final int sum = nums[i] + nums[j];
                if (sum > 0) {
                    break;
                }
                final int index = Arrays.binarySearch(nums, j + 1, nums.length, -sum);
                if (index > 0) {
                    result.add(List.of(nums[i], nums[j], nums[index]));
                }
            }
        }
        return result;
    }
}
