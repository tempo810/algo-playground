package leetcode;

/**
 * @author Tempo
 */
public class SpatialMatrix2 {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int digit = 1;
        int loop = 0;
        while (loop < n) {
            int row = loop;
            int col = loop;
            while (col < matrix[row].length && matrix[row][col] == 0) {
                matrix[row][col++] = digit++;
            }
            col--;
            row++;
            while (row < matrix.length && matrix[row][col] == 0) {
                matrix[row++][col] = digit++;
            }
            row--;
            col--;
            while (col >= 0 && matrix[row][col] == 0) {
                matrix[row][col--] = digit++;
            }
            row--;
            col++;
            while (row >= 0 && matrix[row][col] == 0) {
                matrix[row--][col] = digit++;
            }
            loop++;
        }
        return matrix;
    }
}
