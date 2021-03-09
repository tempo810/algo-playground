package mit;

/**
 * @author Tempo
 */
public class MongeArray {
    public static boolean bruteForce(int[][] arr) {
        int row = arr.length;
        for (int i = 0; i < row - 1; i++) {
            for (int j = 0; j < arr[i].length - 1; j++) {
                int a1 = arr[i][j];
                int a2 = arr[i + 1][j + 1];
                int b1 = arr[i][j + 1];
                int b2 = arr[i + 1][j];
                if (a1 + a2 > b1 + b2) {
                    return false;
                }
            }
        }
        return true;
    }
}
