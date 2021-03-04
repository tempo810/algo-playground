package mit;

/**
 * @author Tempo
 */
public class Matrix {
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

    // wip
    public static int[][] recursive(int[][] a, int[][] b, int aCol, int aRow, int bCol, int bRow, int n) {
        if (n == 1) {
            return new int[][]{{a[aRow][aCol] * b[bRow][bCol]}};
        }
        int[][] matrix = new int[n][n];
        return null;
    }
}
