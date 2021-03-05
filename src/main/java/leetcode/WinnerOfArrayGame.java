package leetcode;

/**
 * @author Tempo
 */
public class WinnerOfArrayGame {
    public int getWinner(int[] arr, int k) {
        int maxValueIndex = 0;
        int count = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > arr[maxValueIndex]) {
                count = 1;
                maxValueIndex = i;
            } else {
                count++;
            }

            if (count >= k) {
                return arr[maxValueIndex];
            }
        }

        return arr[maxValueIndex];
    }
}
