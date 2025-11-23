package leetcode.leetcode75;

import java.util.HashMap;
import java.util.Map;

/**
 * @author tempo
 */
public class MaximumNumberOfKSumPair {
    public int maxOperations(int[] nums, int k) {
        Map<Integer, Integer> seen = new HashMap<>();
        int result = 0;
        for (int num : nums) {
            int lookup = k - num;
            if (seen.containsKey(lookup)) {
                result++;
                seen.compute(lookup, (key, value) -> value - 1 == 0 ? null : value - 1);
            } else {
                seen.compute(num, (key, value) -> value == null ? 1 : value + 1);
            }
        }
        return result;
    }
}
