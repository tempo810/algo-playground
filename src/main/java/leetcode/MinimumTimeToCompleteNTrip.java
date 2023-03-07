package leetcode;

/**
 * @author tempo
 */
public class MinimumTimeToCompleteNTrip {
    public long minimumTime(int[] time, int totalTrips) {
        long min = Integer.MAX_VALUE;
        for (int t : time) {
            min = Math.min(min, t);
        }
        long max = (long) totalTrips * min;
        min = 1L;

        while (min <= max) {
            long mid = (min + max) / 2;
            if (canComplete(mid, time, totalTrips)) {
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }
        return min;
    }

    private boolean canComplete(long totalTime, int[] times, int totalTrips) {
        long completedTrip = 0;
        for (int time : times) {
            completedTrip += totalTime / time;
        }
        return completedTrip >= totalTrips;
    }
}
