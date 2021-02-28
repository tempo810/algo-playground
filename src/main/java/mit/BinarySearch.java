package mit;

/**
 * @author Tempo
 */
public class BinarySearch {
    public static int search(int[] arr, int element) {
        int high = arr.length;
        int low = 0;
        while (low < high) {
            int pivot = (low + high) / 2;
            if (arr[pivot] == element) {
                return pivot;
            } else if (arr[pivot] < element) {
                low = pivot + 1;
            } else {
                high = pivot - 1;
            }
        }
        int pivot = (low + high) / 2;
        return arr[pivot] > element ? pivot - 1 : pivot + 1;
    }
}
