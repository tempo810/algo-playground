package neetcode.blind75;

import java.util.HashSet;
import java.util.Set;

/**
 * @author tempo
 */
public class ContainsDuplicate {
    public boolean hasDuplicate(int[] nums) {
        Set<Integer> seen = new HashSet<>();
        for (int num : nums) {
            if (!seen.add(num)) {
                return true;
            }
        }
        return false;
    }
}
