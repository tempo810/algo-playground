package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Tempo
 */
public class SubArraySumEqualK {
    //[1,2,2,3] k=4 {1,3,5} current - k
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> prefixes = new HashMap<>();
        int prefix = 0;
        int count = 0;
        prefixes.put(0, 1);
        for (int num : nums) {
            prefix += num;
            count += prefixes.getOrDefault(prefix - k, 0);
            prefixes.compute(prefix, (key, val) -> val == null ? 1 : val + 1);
        }
        return count;
    }
}
