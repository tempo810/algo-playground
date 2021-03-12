package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author tempo
 */
public class StringContainsAllBinaryCodesOfSizeK {
    public boolean hasAllCodes(String s, int k) {
        return helper(s, k, "");
    }

    public boolean hasAllCodesV2(String s, int k) {
        Set<String> set = new HashSet<>();
        for (int i = 0; i <= s.length() - k; i++) {
            set.add(s.substring(i, i + k));
        }
        return set.size() == Math.pow(2, k);
    }

    private boolean helper(String s, int k, String partial) {
        if (partial.length() == k) {
            return s.contains(partial);
        }
        return helper(s, k, partial + "0") && helper(s, k, partial + "1");
    }
}
