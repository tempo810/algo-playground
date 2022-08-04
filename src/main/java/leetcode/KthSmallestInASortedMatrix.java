package leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author tempo
 */
public class KthSmallestInASortedMatrix {
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (maxHeap.size() < k) {
                    maxHeap.add(matrix[i][j]);
                } else if (maxHeap.peek() > matrix[i][j]) {
                    maxHeap.poll();
                    maxHeap.add(matrix[i][j]);
                } else {
                    break;
                }
            }
        }
        return maxHeap.peek();
    }
}
