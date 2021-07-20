package leetcode;

import java.util.PriorityQueue;

/**
 * @author Tempo
 */
public class SortIntegerByPowerValue {
    public int getKth(int lo, int hi, int k) {
        int[] dp = new int[300000];
        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> {
            if (a[0] == b[0]) {
                return b[1] - a[1];
            }
            return b[0] - a[0];
        });
        for (int i = lo; i <= hi; i++) {
            int[] temp = new int[]{power(i, dp), i};
            heap.add(temp);
            if (heap.size() > k) {
                heap.poll();
            }
        }
        return heap.poll()[1];
    }

    private int power(int i, int[] dp) {
        if (i == 1) {
            return 0;
        }
        if (dp[i] == 0) {
            if (i % 2 == 0) {
                dp[i] = 1 + power(i / 2, dp);
            } else {
                dp[i] = 1 + power(i * 3 + 1, dp);
            }

        }
        return dp[i];
    }
}
