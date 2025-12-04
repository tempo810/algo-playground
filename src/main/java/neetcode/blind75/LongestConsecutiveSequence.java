package neetcode.blind75;

import java.util.HashSet;
import java.util.Set;

/**
 * @author tempo
 */
public class LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        Set<Integer> seen = new HashSet<>();
        for (int num : nums) {
            seen.add(num);
        }
        int longest = 0;
        for (int num : nums) {
            if (!seen.contains(num - 1)) {
                int currentConsecutive = 1;
                int next = num + 1;
                while (seen.contains(next++)) {
                    currentConsecutive++;
                }
                longest = Math.max(longest, currentConsecutive);
            }
        }
        return longest;
    }
}
