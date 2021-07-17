package leetcode;

/**
 * @author Tempo
 */
public class ThreeEqualPart {
    public int[] threeEqualParts(int[] arr) {
        int nonZeroCount = 0;
        for (int i : arr) {
            if (i != 0) {
                nonZeroCount++;
            }
        }
        if (nonZeroCount == 0) {
            return new int[]{0, 2};
        }
        if (nonZeroCount % 3 != 0) {
            return new int[]{-1, -1};
        }

        int[] startingPosition = new int[3];
        int currentNonZeroCount = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 1) {
                if (currentNonZeroCount % (nonZeroCount / 3) == 0) {
                    startingPosition[currentNonZeroCount / (nonZeroCount / 3)] = i;
                }
                currentNonZeroCount++;
            }
        }

        while (startingPosition[2] < arr.length) {
            if (arr[startingPosition[0]] != arr[startingPosition[1]] || arr[startingPosition[1]] != arr[startingPosition[2]]) {
                return new int[]{-1, -1};
            }
            startingPosition[0]++;
            startingPosition[1]++;
            startingPosition[2]++;
        }
        return new int[]{startingPosition[0] - 1, startingPosition[1]};
    }
}
