package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Tempo
 */
public class LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        Set<Integer> numHash = new HashSet<>();
        for (int num : nums) {
            numHash.add(num);
        }
        int longestSteak = 0;
        for (int num : nums) {
            if (numHash.contains(num)) {
                numHash.remove(num);
                int i = 1;
                while (numHash.contains(num + i)) {
                    numHash.remove(num + i);
                    i++;
                }

                int j = 1;
                while (numHash.contains(num - j)) {
                    numHash.remove(num - j);
                    j++;
                }
                longestSteak = Math.max(longestSteak, i + j - 1);
            }
        }
        return longestSteak;
    }
}
