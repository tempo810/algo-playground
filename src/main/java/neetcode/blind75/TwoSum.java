package neetcode.blind75;

import java.util.HashMap;
import java.util.Map;

/**
 * @author tempo
 */
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> indicesMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int currentValue = nums[i];
            Integer targetIndex = indicesMap.get(target - currentValue);
            if (targetIndex != null) {
                return new int[]{targetIndex, i};
            }
            indicesMap.put(currentValue, i);
        }
        return new int[]{-1, -1};
    }
}
