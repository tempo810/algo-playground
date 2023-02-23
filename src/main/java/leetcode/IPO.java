package leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author tempo
 */
public class IPO {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int[][] entries = new int[profits.length][2];
        for (int i = 0; i < profits.length; i++) {
            entries[i][0] = capital[i];
            entries[i][1] = profits[i];
        }
        Arrays.sort(entries, Comparator.comparingInt(a -> a[0]));
        int currentCapital = w;
        int j = 0;
        PriorityQueue<Integer> profit = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i = 0; i < k; i++) {
            while (j < entries.length && entries[j][0] <= currentCapital) {
                profit.add(entries[j++][1]);
            }
            if (profit.isEmpty()) {
                break;
            }
            currentCapital += profit.poll();
        }
        return currentCapital;
    }
}
