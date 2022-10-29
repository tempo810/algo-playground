package leetcode;

import java.util.Arrays;

/**
 * @author tempo
 */
public class EarliestPossibleDayOfFullBloom {
    public int earliestFullBloom(int[] plantTime, int[] growTime) {
        int[][] times = new int[plantTime.length][2];
        for (int i = 0; i < plantTime.length; i++) {
            times[i][0] = plantTime[i];
            times[i][1] = growTime[i];
        }
        Arrays.sort(times, (a, b) -> Integer.compare(b[1], a[1]));

        int maxDay = 0;
        int nextAvailableDay = 0;
        for (int[] time : times) {
            nextAvailableDay += time[0];
            maxDay = Math.max(maxDay, nextAvailableDay + time[1]);
        }
        return maxDay;
    }
}
