package neetcode.bind150;


import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

/**
 * @author tempo
 */
public class SlidingWindowMaximum {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Queue<Integer> currentQueue = new ArrayDeque<>();
        Deque<Integer> maxQueue = new ArrayDeque<>();
        int[] result = new int[nums.length - k + 1];
        int i = 0;
        for (int num : nums) {
            while (!maxQueue.isEmpty() && maxQueue.peekLast() < num) {
                maxQueue.pollLast();
            }
            currentQueue.add(num);
            maxQueue.add(num);
            if (currentQueue.size() == k) {
                final Integer currentNum = currentQueue.poll();
                result[i++] = maxQueue.peek();
                if (currentNum == maxQueue.peek()) {
                    maxQueue.poll();
                }
            }
        }
        return result;
    }
}
