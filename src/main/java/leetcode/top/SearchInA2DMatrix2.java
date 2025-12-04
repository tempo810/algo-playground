package leetcode.top;

/**
 * @author tempo
 */
public class SearchInA2DMatrix2 {
    public boolean searchMatrix(int[][] matrix, int target) {
        return this.search(matrix, target, 0, matrix.length - 1, 0, matrix[0].length - 1);

    }

    private boolean search(int[][] matrix, int target, int rowStart, int rowEnd, int colStart, int colEnd) {
        if (target > matrix[rowEnd][colEnd] || target < matrix[rowStart][colStart]) {
            return false;
        }
        int rightTopValue = matrix[rowStart][colEnd];
        if (target > rightTopValue) {
            int newRowStart = this.filterRow(matrix, rowStart, rowEnd, colEnd, target);
            return this.search(matrix, target, newRowStart, rowEnd, colStart, colEnd);
        } else if (target < rightTopValue) {
            int newColEnd = this.filterCol(matrix, rowStart, colStart, colEnd, target);
            return this.search(matrix, target, rowStart, rowEnd, colStart, newColEnd);
        } else {
            return true;
        }
    }

    private int filterCol(int[][] matrix, int row, int colStart, int colEnd, int target) {
        int left = colStart;
        int right = colEnd;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (matrix[row][mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return right;
    }

    private int filterRow(int[][] matrix, int rowStart, int rowEnd, int col, int target) {
        int left = rowStart;
        int right = rowEnd;
        while (left <= right) { // move down when target > current
            int mid = left + (right - left) / 2;
            if (matrix[mid][col] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }
}
