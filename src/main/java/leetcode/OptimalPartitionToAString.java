package leetcode;

import java.util.Arrays;

/**
 * @author tempo
 */
public class OptimalPartitionToAString {
    public int partitionString(String s) {
        boolean[] seen = new boolean[26];
        int totalPartition = 1;
        for (char aChar : s.toCharArray()) {
            if (seen[aChar - 'a']) {
                totalPartition++;
                Arrays.fill(seen, false);
            }
            seen[aChar - 'a'] = true;
        }
        return totalPartition;
    }
}
