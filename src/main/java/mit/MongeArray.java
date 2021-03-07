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

    public static boolean greedy(int[][] arr) {
        int globalMinIndex = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            int localMinIndex = 0;
            for (int j = 1; j < arr[i].length; j++) {
                if (arr[i][j] < arr[i][localMinIndex]) {
                    localMinIndex = j;
                }
            }
            if (localMinIndex < globalMinIndex) {
                return false;
            } else {
                globalMinIndex = localMinIndex;
            }
        }
        return true;
    }

    public static boolean divideAndConquer(int[][] arr) {
        return divideAndConquer(arr, 0, arr.length);
    }

    private static boolean divideAndConquer(int[][] arr, int low, int high) {
        if (low == high) {
            return true;
        }
        return false;
    }
}
