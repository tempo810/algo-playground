package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Tempo
 */
public class PartitionLabels {
    public List<Integer> partitionLabels(String s) {
        int[] lastIndices = new int[26];

        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            lastIndices[chars[i] - 'a'] = i;
        }

        int maxIndex = -1;
        int lastIndex = -1;
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < chars.length; i++) {
            maxIndex = Math.max(lastIndices[chars[i] - 'a'], maxIndex);
            if (i == maxIndex) {
                result.add(maxIndex - lastIndex);
                lastIndex = maxIndex;
            }
        }
        return result;
    }
}
