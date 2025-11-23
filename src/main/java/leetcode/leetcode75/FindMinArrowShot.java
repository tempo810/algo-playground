package leetcode.leetcode75;

import java.util.Arrays;

/**
 * @author tempo
 */
public class FindMinArrowShot {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (a, b) -> a[0] != b[0] ? Integer.compare(a[0], b[0]) : Integer.compare(a[1], b[1]));
        int maxRangeOfArrow = points[0][1];
        int numberOfArrow = 1;

        for (int i = 1; i < points.length; i++) {
            int[] currentRange = points[i];
            // min = 1 max = 10  -> 2, 5
            if (currentRange[0] <= maxRangeOfArrow) {
                maxRangeOfArrow = Math.max(maxRangeOfArrow, currentRange[1]);
            } else {
                numberOfArrow++;
                maxRangeOfArrow = currentRange[1];
            }
        }

        return numberOfArrow;
    }
}
