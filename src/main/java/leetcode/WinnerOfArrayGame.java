package leetcode;

/**
 * @author Tempo
 */
public class WinnerOfArrayGame {
    public int getWinner(int[] arr, int k) {
        int maxValue = arr[0];
        int count = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > maxValue) {
                count = 1;
                maxValue = arr[i];
            } else {
                count++;
            }

            if (count >= k) {
                break;
            }
        }

        return maxValue;
    }
}
