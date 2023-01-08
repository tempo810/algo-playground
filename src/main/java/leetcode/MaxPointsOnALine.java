package leetcode;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * @author tempo
 */
public class MaxPointsOnALine {
    public int maxPoints(int[][] points) {
        if (points.length < 2) {
            return points.length;
        }

        int result = 0;
        for (int i = 0; i < points.length; i++) {
            Map<Double, Integer> slopeFrequencies = new HashMap<>();
            for (int j = 0; j < points.length; j++) {
                if (i != j) {
                    slopeFrequencies.compute(Math.atan2(points[i][0] - points[j][0], points[i][1] - points[j][1]), (k, v) -> v == null ? 2 : v + 1);
                }
            }
            result = Math.max(result, Collections.max(slopeFrequencies.values()));
        }
        return result;
    }
}
