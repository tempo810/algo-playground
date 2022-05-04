package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Tempo
 */
public class MaxNumberOfKSumPairs {
    public int maxOperations(int[] nums, int k) {
        Map<Integer, Integer> counter = new HashMap<>();
        int result = 0;
        for (int num : nums) {
            Integer pairCount = counter.getOrDefault(k - num, 0);
            if (pairCount > 0) {
                counter.put(k - num, pairCount - 1);
                result++;
            } else {
                counter.compute(num, (key, v) -> v == null ? 1 : v + 1);
            }
        }
        return result;
    }
}
