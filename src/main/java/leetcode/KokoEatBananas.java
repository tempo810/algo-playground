package leetcode;

import java.util.Arrays;

/**
 * @author Tempo
 */
public class KokoEatBananas {
    public int minEatingSpeed(int[] piles, int h) {
        Arrays.sort(piles);

        int hi = piles[piles.length - 1];
        int lo = 1;

        while (hi > lo) {
            int mid = (hi - lo) / 2 + lo;
            int currentHour = 0;
            int i = piles.length - 1;
            for (; i >= 0; i--) {
                if (piles[i] <= mid) {
                    i++;
                    break;
                }
                currentHour += Math.ceil((double) piles[i] / mid);

            }
            if (i > 0) {
                currentHour += i;
            }

            if (currentHour > h) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return lo;
    }
}
