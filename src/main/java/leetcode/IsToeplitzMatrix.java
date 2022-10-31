package leetcode;

/**
 * @author tempo
 */
public class IsToeplitzMatrix {
    public boolean isToeplitzMatrix(int[][] matrix) {
        int width = matrix[0].length;
        for (int i = 0; i < width; i++) {
            for (int j = 1; j < matrix.length && j + i < width; j++) {
                if (matrix[0][i] != matrix[j][j + i]) {
                    return false;
                }
            }
        }
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; i + j < matrix.length && j < width; j++) {
                if (matrix[i][0] != matrix[i + j][j]) {
                    return false;
                }
            }
        }
        return true;
    }
}
