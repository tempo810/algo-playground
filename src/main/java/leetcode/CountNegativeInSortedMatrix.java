package leetcode;

/**
 * @author Tempo
 */
public class CountNegativeInSortedMatrix {
    public int countNegatives(int[][] grid) {
        int count = 0;
        for (int i = grid.length - 1; i >= 0; i--) {
            int temp = 0;
            for (int j = grid[i].length - 1; j >= 0; j--) {
                if (grid[i][j] < 0) {
                    temp++;
                } else {
                    break;
                }
            }
            if (temp == 0) {
                break;
            }
            count += temp;
        }

        return count;
    }
}
