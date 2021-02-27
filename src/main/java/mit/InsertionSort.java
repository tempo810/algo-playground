package mit;

/**
 * @author Tempo
 */
public class InsertionSort {
    static void asc(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int j = i - 1;
            while (j >= 0 && arr[j] > arr[j + 1]) {
                int temp = arr[j];
                arr[j] = arr[j + 1];
                arr[j + 1] = temp;
                j--;
            }
        }
    }

    static void desc(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int j = i - 1;
            while (j >= 0 && arr[j] < arr[j + 1]) {
                int temp = arr[j];
                arr[j] = arr[j + 1];
                arr[j + 1] = temp;
                j--;
            }
        }
    }
}
