package leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author Tempo
 */

// can be improved by using priority queue
public class MeetingRoom2 {
    public int maxRoomV2(int[][] interval) {
        Arrays.sort(interval, Comparator.comparingInt(arr -> arr[0]));
        int globalMax = 0;
        int max = 0;
        Queue<Integer> free = new PriorityQueue<>();
        for (int[] ints : interval) {
            if (free.isEmpty() || free.peek() > ints[0]) {
                globalMax = Math.max(globalMax, ++max);
            } else {
                free.remove();
                max--;
            }
            free.offer(ints[1]);
        }
        return max;
    }

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
