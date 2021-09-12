package leetcode;

/**
 * @author Tempo
 */
public class CapacityToShipPackagesWithinDDays {
    public int shipWithinDays(int[] weights, int days) {
        int min = 0;
        int max = 0;
        for (int weight : weights) {
            min = Math.max(weight, min);
            max += weight;
        }

        while (min < max) {
            int mid = min + (max - min) / 2;
            if (canShip(weights, mid, days)) {
                max = mid;
            } else {
                min = mid + 1;
            }
        }
        return min;
    }

    private boolean canShip(int[] weights, int capacity, int days) {
        int totalDay = 1;
        int dailyWeight = 0;
        for (int weight : weights) {
            dailyWeight += weight;
            if (dailyWeight > capacity) {
                totalDay++;
                dailyWeight = weight;
            }
        }
        return totalDay <= days;
    }
}
