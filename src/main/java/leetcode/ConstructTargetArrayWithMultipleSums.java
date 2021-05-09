package leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author Tempo
 */
public class ConstructTargetArrayWithMultipleSums {
    public boolean isPossible(int[] target) {
        Queue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        int total = 0;
        for (int j : target) {
            maxHeap.add(j);
            total += j;
        }

        while (maxHeap.peek() != 1) {
            int num = maxHeap.poll();
            total -= num;
            if (num <= total || total < 1) return false;
            num %= total;
            total += num;
            maxHeap.add(num);
        }
        return true;
    }
}
