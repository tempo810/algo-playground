package leetcode.leetcode75;

import java.util.Arrays;

/**
 * @author tempo
 */
public class NonoverlappingInterval {
    public int eraseOverlapIntervals(int[][] intervals) {
        // case 1: starting interval same -> [1, 2] [1, 3] [1, 4]  , always keep the tightest interval
        // case 2: overlapping of end interval -> [1, 5] [2, 3], keep end smaller, also tightest

        Arrays.sort(intervals, (a, b) -> a[0] != b[0] ? a[0] - b[0] : a[1] - b[1]);
        int eraseCount = 0;
        int[] lastKeptInterval = intervals[0];

        for (int i = 1; i < intervals.length; i++) {
            final int[] currentInterval = intervals[i];
            if (currentInterval[0] == lastKeptInterval[0]) {
                eraseCount++;
            } else if (lastKeptInterval[1] > currentInterval[0]) {
                eraseCount++;
                lastKeptInterval = lastKeptInterval[1] >= currentInterval[1] ? currentInterval : lastKeptInterval;
            } else {
                lastKeptInterval = currentInterval;
            }
        }

        return eraseCount;
    }
}
