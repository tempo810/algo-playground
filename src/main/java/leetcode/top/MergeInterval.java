package leetcode.top;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author tempo
 */
public class MergeInterval {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]); // sort by start time in asc order;
        List<int[]> temp = new ArrayList<>();
        temp.add(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            int[] currentInterval = intervals[i];
            int[] lastInterval = temp.get(temp.size() - 1);
            if (currentInterval[0] > lastInterval[1]) {
                temp.add(currentInterval);
            } else {
                lastInterval[1] = Math.max(lastInterval[1], currentInterval[1]);
            }
        }
        return temp.toArray(int[][]::new);
    }
}
