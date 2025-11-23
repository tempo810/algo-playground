package leetcode.leetcode75;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author tempo
 */
public class DailyTemperatures {
    public int[] dailyTemperatures(int[] temperatures) {
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparing(a -> a[0]));
        int[] result = new int[temperatures.length];
        for (int i = 0; i < temperatures.length; i++) {
            while (!minHeap.isEmpty() && minHeap.peek()[0] < temperatures[i]) {
                int[] temp = minHeap.poll();
                result[temp[1]] = i - temp[1];
            }
            minHeap.add(new int[]{temperatures[i], i});
        }
        result[result.length - 1] = 0;
        return result;
    }
}
