package mit;

/**
 * @author Tempo
 */
public class MatrixMultiplication {
    public static int[][] multiplyBruteForce(int[][] a, int[][] b) {
        int[][] c = new int[a.length][a.length];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length; j++) {
                for (int k = 0; k < a.length; k++) {
                    c[i][j] += a[i][k] * b[k][j];
                }
            }
        }
        return c;
    }

    public static int[][] recursive(int[][] a, int[][] b, int aRow, int aCol, int bRow, int bCol, int n) {
        if (n == 1) {
            return new int[][]{{a[aRow][aCol] * b[bRow][bCol]}};
        }

        int[][] matrix = new int[n][n];
        int newLength = n / 2;
        //c11 = (a11 * b11) + (a12 * b21)
        add(matrix, recursive(a, b, aRow, aCol, bRow, bCol, newLength), recursive(a, b, aRow, aCol + newLength, bRow + newLength, bCol, newLength), 0, 0);
        //c12 = (a11 * b12) + (a12 * b22)
        add(matrix, recursive(a, b, aRow, aCol, bRow, bCol + newLength, newLength), recursive(a, b, aRow, aCol + newLength, bRow + newLength, bCol + newLength, newLength), 0, newLength);
        //c21 = (a21 * b11) + (a22 * b21)
        add(matrix, recursive(a, b, aRow + newLength, aCol, bRow, bCol, newLength), recursive(a, b, aRow + newLength, aCol + newLength, bRow + newLength, bCol, newLength), newLength, 0);
        //c22 = (a21 * b12) + (a22 * b22)
        add(matrix, recursive(a, b, aRow + newLength, aCol, bRow, bCol + newLength, newLength), recursive(a, b, aRow + newLength, aCol + newLength, bRow + newLength, bCol + newLength, newLength), newLength, newLength);
        return matrix;
    }

    private static void add(int[][] matrix, int[][] a, int[][] b, int row, int col) {
        int length = a.length;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                matrix[i + row][j + col] = a[i][j] + b[i][j];
            }
        }
    }
}
