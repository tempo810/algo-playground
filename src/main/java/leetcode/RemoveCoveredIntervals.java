package leetcode;

import java.util.Arrays;

/**
 * @author Tempo
 */
public class RemoveCoveredIntervals {
    public int removeCoveredIntervals(int[][] intervals) {
        Arrays.sort(intervals, (o1, o2) -> {
            int diff = o1[0] - o2[0];
            if (diff == 0) return o2[1] - o1[1];
            return diff;
        });

        int hi = intervals[0][1];
        int removed = 0;

        for (int i = 1; i < intervals.length; i++) {
            int currentHi = intervals[i][1];
            if (currentHi <= hi) {
                removed++;
            } else {
                hi = currentHi;
            }
        }
        return intervals.length - removed;
    }
}
