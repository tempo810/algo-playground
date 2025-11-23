package leetcode;

import java.util.Arrays;


/**
 * @author tempo
 */
public class SetIntersectionSizeAtLeastTwo {
    public int intersectionSizeTwo(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> {
            if (a[1] == b[1]) {
                return b[0] - a[0];
            }
            return a[1] - b[1];
        });

        int count = 2;
        int largest = intervals[0][1];
        int secondLargest = largest - 1;

        int[] lastInterval = intervals[0];
        for (int i = 1; i <= intervals.length - 1; i++) {
            int[] currentInterval = intervals[i];
            if (currentInterval[1] == lastInterval[1]) {
                continue;
            }
            lastInterval = currentInterval;
            int start = currentInterval[0];
            int end = currentInterval[1];
            if (secondLargest >= start && largest <= end) {
                continue;
            }
            if (start > largest) {
                count += 2;
                largest = end;
                secondLargest = largest - 1;
            } else {
                count++;
                secondLargest = largest;
                largest = end;
            }

        }
        return count;
    }
}
