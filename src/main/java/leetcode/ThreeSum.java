package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Tempo
 */
public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> zeroSums = new ArrayList<>();

        for (int i = 0; i < nums.length - 2; i++) {
            if (i != 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int lastK = nums.length - 1;
            for (int j = i + 1; j < nums.length - 1; j++) {
                if (j != i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }

                int target = (nums[i] + nums[j]) * -1;
                int low = j + 1;
                int high = lastK;
                while (low <= high) {
                    int current = (low + high) / 2;
                    if (nums[current] == target) {
                        zeroSums.add(List.of(nums[i], nums[j], nums[current]));
                        lastK = current;
                        break;
                    }

                    if (nums[current] < target) {
                        low = current + 1;
                    } else {
                        high = current - 1;
                    }
                }
            }
        }
        return zeroSums;
    }
}
