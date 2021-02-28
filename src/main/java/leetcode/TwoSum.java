package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Tempo
 */
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> candidates = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer index = candidates.get(target - nums[i]);
            if (index != null) {
                return new int[]{index, i};
            } else {
                candidates.put(nums[i], i);
            }
        }
        return new int[]{};
    }
}
