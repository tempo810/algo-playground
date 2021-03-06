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

    public static int[][] strassen(int[][] a, int[][] b) {
        int n = a.length;
        int[][] C = new int[n][n];

        if (n == 1) {
            C[0][0] = a[0][0] * b[0][0];
        } else {
            int[][] A11 = partial(a, 0, 0, n / 2);
            int[][] A12 = partial(a, 0, n / 2, n / 2);
            int[][] A21 = partial(a, n / 2, 0, n / 2);
            int[][] A22 = partial(a, n / 2, n / 2, n / 2);
            int[][] B11 = partial(b, 0, 0, n / 2);
            int[][] B12 = partial(b, 0, n / 2, n / 2);
            int[][] B21 = partial(b, n / 2, 0, n / 2);
            int[][] B22 = partial(b, n / 2, n / 2, n / 2);

            int[][] S1 = subtract(B12, B22);
            int[][] S2 = add(A11, A12);
            int[][] S3 = add(A21, A22);
            int[][] S4 = subtract(B21, B11);
            int[][] S5 = add(A11, A22);
            int[][] S6 = add(B11, B22);
            int[][] S7 = subtract(A12, A22);
            int[][] S8 = add(B21, B22);
            int[][] S9 = subtract(A11, A21);
            int[][] S10 = add(B11, B12);

            int[][] P1 = strassen(A11, S1);
            int[][] P2 = strassen(S2, B22);
            int[][] P3 = strassen(S3, B11);
            int[][] P4 = strassen(A22, S4);
            int[][] P5 = strassen(S5, S6);
            int[][] P6 = strassen(S7, S8);
            int[][] P7 = strassen(S9, S10);

            add(C, subtract(add(P5, P4), P2), P6, 0, 0);
            add(C, P1, P2, 0, n / 2);
            add(C, P3, P4, n / 2, 0);
            add(C, P5, subtract(subtract(P1, P3), P7), n / 2, n / 2);
        }
        return C;
    }

    private static void add(int[][] matrix, int[][] a, int[][] b, int row, int col) {
        int length = a.length;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                matrix[i + row][j + col] = a[i][j] + b[i][j];
            }
        }
    }

    private static int[][] add(int[][] a, int[][] b) {
        int[][] sub = new int[a.length][a.length];
        for (int i = 0; i < sub.length; i++) {
            for (int j = 0; j < sub[i].length; j++) {
                sub[i][j] = a[i][j] + b[i][j];
            }
        }
        return sub;
    }

    private static int[][] subtract(int[][] a, int[][] b) {
        int[][] sub = new int[a.length][a.length];
        for (int i = 0; i < sub.length; i++) {
            for (int j = 0; j < sub[i].length; j++) {
                sub[i][j] = a[i][j] - b[i][j];
            }
        }
        return sub;
    }

    private static int[][] partial(int[][] a, int row, int col, int size) {
        int[][] subMatrix = new int[size][size];
        for (int i = 0; i < size; i++) {
            System.arraycopy(a[i + row], col, subMatrix[i], 0, size);
        }
        return subMatrix;
    }
}
