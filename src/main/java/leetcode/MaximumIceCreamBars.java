package leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author tempo
 */
public class MaximumIceCreamBars {
    public int maxIceCream(int[] costs, int coins) {
        PriorityQueue<Integer> bars = new PriorityQueue<>(Comparator.reverseOrder());
        int remainingCoins = coins;
        for (int cost : costs) {
            if (cost <= remainingCoins) {
                bars.add(cost);
                remainingCoins -= cost;
            } else if (!bars.isEmpty() && cost < bars.peek()) {
                remainingCoins += bars.poll() - cost;
                bars.add(cost);
            }
        }
        return bars.size();
    }
}
