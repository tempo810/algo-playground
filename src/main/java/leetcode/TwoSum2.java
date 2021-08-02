package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author tempo
 */
public class TwoSum2 {
    public int[] twoSum(int[] numbers, int target) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            map.computeIfAbsent(numbers[i], key -> new ArrayList<>()).add(i);
        }
        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            int remaining = target - entry.getKey();
            List<Integer> remainingEntries = map.get(remaining);
            if (remainingEntries != null) {
                if (remaining != entry.getKey()) {
                    return new int[]{remainingEntries.get(0), entry.getValue().get(0)};
                } else if (remainingEntries.size() > 1) {
                    return new int[]{remainingEntries.get(0), remainingEntries.get(1)};
                }
            }
        }
        return new int[]{};
    }
}
