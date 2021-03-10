package leetcode;

import java.util.Arrays;

/**
 * @author Tempo
 */

// can be improved by using priority queue
public class MeetingRoom2 {
    public int maxRoom(int[][] interval) {
        int[] start = new int[interval.length];
        int[] end = new int[interval.length];

        for (int i = 0; i < interval.length; i++) {
            start[i] = interval[i][0];
            end[i] = interval[i][1];
        }

        Arrays.sort(start);
        Arrays.sort(end);
        int max = 0;
        int free = 0;
        int startIndex = 0;
        int endIndex = 0;
        while (startIndex < start.length) {
            if (start[startIndex] < end[endIndex]) {
                if (free == 0) {
                    max++;
                } else {
                    free--;
                }
                startIndex++;
            } else if (start[startIndex] > end[endIndex]) {
                free++;
                endIndex++;
            } else {
                startIndex++;
                endIndex++;
            }
        }
        return max;
    }
}
