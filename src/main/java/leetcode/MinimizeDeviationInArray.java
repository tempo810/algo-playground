package leetcode;

import java.util.NavigableSet;
import java.util.TreeSet;

/**
 * @author tempo
 */
public class MinimizeDeviationInArray {
    public int minimumDeviation(int[] nums) {
        NavigableSet<Integer> treeSet = new TreeSet<>();
        for (int num : nums) {
            if (num % 2 == 0) {
                treeSet.add(num);
            } else {
                treeSet.add(num * 2);
            }
        }

        int answer = Integer.MAX_VALUE;
        while (true) {
            answer = Math.min(answer, treeSet.last() - treeSet.first());
            int largestValue = treeSet.pollLast();
            if (largestValue % 2 == 0) {
                treeSet.add(largestValue / 2);
            } else {
                break;
            }
        }
        return answer;
    }
}
