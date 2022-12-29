package leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author tempo
 */
public class SingleThreadCpu {
    public int[] getOrder(int[][] tasks) {
        int[][] indexedTasks = new int[tasks.length][3];

        for (int i = 0; i < tasks.length; i++) {
            indexedTasks[i] = Arrays.copyOf(tasks[i], 3);
            indexedTasks[i][2] = i;
        }
        Arrays.sort(indexedTasks, Comparator.comparingInt((int[] a) -> a[0]).thenComparingInt(a -> a[1]));
        PriorityQueue<int[]> taskQueue = new PriorityQueue<>(Comparator.comparingInt((int[] arr) -> arr[1]).thenComparingInt(arr -> arr[2]));
        int[] result = new int[tasks.length];
        int currentTime = 0;
        int currentIndex = 0;
        int resultIndex = 0;
        while (currentIndex < tasks.length) {
            while (currentIndex < tasks.length && (taskQueue.isEmpty() || indexedTasks[currentIndex][0] <= currentTime)) {
                taskQueue.add(indexedTasks[currentIndex++]);
            }
            int[] currentTask = taskQueue.poll();
            result[resultIndex++] = currentTask[2];
            currentTime += Math.max(currentTask[0], currentTime) + currentTask[1];

        }

        while (!taskQueue.isEmpty()) {
            result[resultIndex++] = taskQueue.poll()[2];
        }

        return result;
    }
}
