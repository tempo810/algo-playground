package leetcode.leetcode75;

import java.util.HashMap;
import java.util.Map;

/**
 * @author tempo
 */
public class EqualRowAndColumnPairs {
    public int equalPairs(int[][] grid) {
        Map<String, Integer> occurrenceMap = new HashMap<>();
        final int length = grid.length;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                sb.append(grid[i][j]).append(',');
            }
            occurrenceMap.merge(sb.toString(), 1, Integer::sum);
            sb.setLength(0);
        }

        int total = 0;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                sb.append(grid[j][i]).append(',');
            }
            total += occurrenceMap.getOrDefault(sb.toString(), 0);
            sb.setLength(0);
        }
        return total;

    }
}
