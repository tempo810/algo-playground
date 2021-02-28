package mit;

/**
 * @author Tempo
 */
public class InsertionSort {
    static void asc(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int current = arr[i];

            int j = i - 1;
            while (j >= 0 && arr[j] > current) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = current;
        }
    }

    static void ascWithBinarySearch(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int current = arr[i];
            int high = i;
            int low = 0;
            while (low <= high) {
                int pivot = (low + high) / 2;
                if (current <= arr[pivot]) {
                    high = pivot - 1;
                } else {
                    low = pivot + 1;
                }
            }
            System.arraycopy(arr, low, arr, low + 1, i - low);
            arr[low] = current;
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
