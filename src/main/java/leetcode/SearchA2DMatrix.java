package leetcode;

/**
 * @author Tempo
 */
public class SearchA2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int left = 0;
        int right = matrix[0].length;
        for (int i = 0; i < matrix.length; i++) {
            left = 0;
            while (left <= right && right >= 0 && left < matrix[0].length) {
                int mid = (left + right) / 2;
                int val = matrix[i][mid];
                if (val == target) {
                    return true;
                }
                if (val < target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }

        return false;
    }
}
