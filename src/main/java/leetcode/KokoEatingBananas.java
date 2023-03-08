package leetcode;

/**
 * @author tempo
 */
public class KokoEatingBananas {
    public int minEatingSpeed(int[] piles, int h) {
        int minSpeed = 1;
        int maxSpeed = 1;
        for (int pile : piles) {
            maxSpeed = Math.max(pile, maxSpeed);
        }
        maxSpeed *= piles.length;
        while (minSpeed < maxSpeed) {
            int mid = (maxSpeed - minSpeed) / 2 + minSpeed;
            if (!canFinish(mid, piles, h)) {
                minSpeed = mid + 1;
            } else {
                maxSpeed = mid;
            }
        }
        return minSpeed;
    }

    private boolean canFinish(int rate, int[] piles, int h) {
        int totalHr = 0;
        for (int pile : piles) {
            totalHr += pile / rate;
            if (pile % rate != 0) {
                totalHr++;
            }
        }
        return totalHr <= h;
    }
}
