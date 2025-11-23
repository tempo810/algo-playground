package leetcode.leetcode75;

import java.util.Arrays;

/**
 * @author tempo
 */
public class MinEatingSpeed {
    public int minEatingSpeed(int[] piles, int h) {
        int minEatSpeed = 1;
        Arrays.sort(piles);
        int maxEatSpeed = piles[piles.length - 1];
        while (minEatSpeed <= maxEatSpeed) {
            int mid = minEatSpeed + (maxEatSpeed - minEatSpeed) / 2;
            int hour = 0;
            for (int i = piles.length - 1; i >= 0 && hour <= h; i--) {
                hour += piles[i] / mid;
                if (piles[i] % mid != 0) {
                    hour++;
                }
            }
            if (hour > h) { // need to increase eating speed
                minEatSpeed = mid + 1;
            } else {
                maxEatSpeed = mid - 1;
            }
        }
        return minEatSpeed;
    }
}
