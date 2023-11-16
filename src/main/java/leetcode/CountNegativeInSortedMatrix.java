package leetcode;

/**
 * @author Tempo
 */
public class CountNegativeInSortedMatrix {
    public int countNegatives(int[][] grid) {
        int count = 0;
        int high = grid[0].length - 1;
        for (int[] line : grid) {
            int index = search(line, 0, high);
            if (line[index] < 0) {
                count += line.length - index;
            }
            high = index;

        }
        return count;
    }

    private int search(int[] arr, int low, int high) {
        while (low < high) {
            int mid = (high - low) / 2 + low;
            if (arr[mid] >= 0) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return high;
    }
}
