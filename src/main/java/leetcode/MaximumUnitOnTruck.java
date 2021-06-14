package leetcode;

import java.util.Arrays;

/**
 * @author Tempo
 */
public class MaximumUnitOnTruck {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, (a, b) -> Integer.compare(b[1], a[1]));
        int remainingSize = truckSize;
        int totalBox = 0;
        for (int i = 0; i < boxTypes.length && remainingSize > 0; i++) {
            int numOfBox = Math.min(boxTypes[i][0], remainingSize);
            totalBox += numOfBox * boxTypes[i][1];
            remainingSize -= numOfBox;
        }
        return totalBox;
    }
}
