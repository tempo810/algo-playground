package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author tempo
 */
public class InsertInterval {
    public static void main(String[] args) {
        int i = 0;
        for (; i < 10; i++) {
            if (i == 3) {
                break;
            }
        }
        System.out.println(i);
    }

    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> tempResult = new ArrayList<>();
        int i = 0;
        for (; i < intervals.length; i++) {
            int[] currentInterval = intervals[i];

            if (isOverlapped(currentInterval, newInterval)) {
                newInterval[0] = Math.min(currentInterval[0], newInterval[0]);
                newInterval[1] = Math.max(currentInterval[1], newInterval[1]);
            } else if (currentInterval[0] > newInterval[1]) {
                break;
            } else {
                tempResult.add(currentInterval);
            }
        }
        int[][] result = new int[tempResult.size() + intervals.length - i + 1][2];
        for (int j = 0; j < result.length; j++) {
            if (j < tempResult.size()) {
                result[j] = tempResult.get(j);
            } else if (j == tempResult.size()) {
                result[j] = newInterval;
            } else {
                result[j] = intervals[i++];
            }
        }
        return result;
    }

    private boolean isOverlapped(int[] intervalA, int[] intervalB) {
        if (intervalB[0] >= intervalA[0] && intervalB[0] <= intervalA[1]) return true;
        if (intervalA[0] >= intervalB[0] && intervalA[0] <= intervalB[1]) return true;
        if (intervalB[1] >= intervalA[0] && intervalB[1] <= intervalA[1]) return true;
        return intervalA[1] >= intervalB[0] && intervalA[1] <= intervalB[1];
    }
}
