package leetcode;

/**
 * @author tempo
 */
public class SortTheMatrixDiagonally {
    // too tedious to finish
    public int[][] diagonalSort(int[][] mat) {
        int maxRow = mat.length - 1;
        int maxCol = mat[0].length - 1;
        for (int currentRow = 0; currentRow <= maxRow; currentRow++) {
            quickSort(currentRow, 0, maxRow, maxRow - currentRow, mat);

        }

        for (int currentCol = 1; currentCol <= maxCol; currentCol++) {
            quickSort(0, currentCol, maxCol - currentCol, maxCol, mat);
        }

        return mat;
    }

    private void quickSort(int currentRow, int currentCol, int maxRow, int maxCol, int[][] matrix) {
        if (currentRow < 0 || currentCol < 0 || currentRow >= matrix.length || currentCol >= matrix[0].length || currentRow >= maxRow) {
            return;
        }

        int pivotRowIndex = partition(currentRow, currentCol, maxRow, maxCol, matrix);

        int leftDiff = pivotRowIndex - 1 - currentRow;
        if (leftDiff > 0) {
            quickSort(currentRow, currentCol, pivotRowIndex - 1, currentCol + leftDiff, matrix);
        }

        int rightDiff = maxRow - (pivotRowIndex + 1);
        if (rightDiff > 0) {
            quickSort(pivotRowIndex + 1, currentCol + rightDiff, maxRow, maxCol, matrix);
        }

    }

    private int partition(int currentRow, int currentCol, int maxRow, int maxCol, int[][] matrix) {
        int pivot = matrix[maxRow][maxCol];

        int low = 0;
        int j = currentCol;
        for (int i = currentRow; i < maxRow; i++, j++) {
            if (matrix[i][j] < pivot) {
                swap(currentRow + low, currentCol + low, i, j, matrix);
                low++;
            }
        }
        swap(currentRow + low, currentCol + low, maxRow, maxCol, matrix);
        return currentRow + low;
    }

    private void swap(int targetRow, int targetCol, int row, int col, int[][] matrix) {
        if (targetRow != row) {
            matrix[targetRow][targetCol] ^= matrix[row][col];
            matrix[row][col] ^= matrix[targetRow][targetCol];
            matrix[targetRow][targetCol] ^= matrix[row][col];
        }
    }
}
