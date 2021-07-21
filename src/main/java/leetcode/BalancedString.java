package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Tempo
 */
public class BalancedString {
    public int balanceString(String s) {
        Map<Character, Integer> counts = new HashMap<>();
        counts.put('Q', 0);
        counts.put('W', 0);
        counts.put('E', 0);
        counts.put('R', 0);

        for (char c : s.toCharArray()) {
            counts.computeIfPresent(c, (k, v) -> v + 1);
        }

        int target = s.length() / 4;
        int diff = 0;
        for (Integer value : counts.values()) {
            if (value < target) {
                diff += target - value;
            }
        }
        return diff;

    }
}
