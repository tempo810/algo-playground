package leetcode;

/**
 * @author Tempo
 */
public class CapacityToShipPackagesWithinDDays {
    public int shipWithinDays(int[] weights, int days) {
        int minWeight = 0;
        int maxWeight = 0;

        for (int weight : weights) {
            minWeight = Math.max(minWeight, weight);
            maxWeight += weight;
        }

        while (minWeight < maxWeight) {
            int capacity = (minWeight + maxWeight) / 2;
            if (canShip(capacity, days, weights)) {
                maxWeight = capacity;
            } else {
                minWeight = capacity + 1;
            }
        }
        return maxWeight;
    }

    private boolean canShip(int maxCapacity, int maxDays, int[] weights) {
        int currentCapacity = 0;
        int currentDays = 1;

        for (int i = 0; i < weights.length && currentDays <= maxDays; i++) {
            currentCapacity += weights[i];
            if (currentCapacity > maxCapacity) {
                currentDays++;
                currentCapacity = weights[i];
            }
        }

        return currentDays <= maxDays;
    }
}
