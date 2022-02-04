package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Tempo
 */
public class ContiguousArray {
    public int findMaxLength(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int sum = 0, maxLength = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i] == 1 ? 1 : -1;
            Integer prev = map.get(sum);
            if (prev != null) {
                maxLength = Math.max(maxLength, i - prev);
            } else {
                map.put(sum, i);
            }
        }
        return maxLength;
    }
}
