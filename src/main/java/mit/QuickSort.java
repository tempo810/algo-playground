package mit;

/**
 * @author tempo
 */
public class QuickSort {
    public static void sortHoare(int[] arr, int start, int end) {
        if (end > start) {
            int pivot = partitionHoare(arr, start, end);
            sortHoare(arr, start, pivot - 1);
            sortHoare(arr, pivot + 1, end);
        }
    }

    private static int partitionHoare(int[] arr, int start, int end) {
        int pivot = arr[start];
        int low = start;
        int high = end;
        while (low < high) {
            while (arr[high] > pivot) {
                high--;
            }
            while (arr[low] < pivot) {
                low++;
            }
            if (low < high) {
                int temp = arr[low];
                arr[low] = arr[high];
                arr[high] = temp;
            }
        }
        return high;
    }

    public static void sort(int[] arr, int start, int end) {
        if (end > start) {
            int pivot = partition(arr, start, end);
            sort(arr, start, pivot - 1);
            sort(arr, pivot + 1, end);
        }
    }

    private static int partition(int[] arr, int start, int end) {
        int pivot = arr[end];
        int lowPointer = start - 1;
        for (int i = start; i <= end - 1; i++) {
            if (arr[i] <= pivot) {
                lowPointer++;
                int temp = arr[i];
                arr[i] = arr[lowPointer];
                arr[lowPointer] = temp;
            }
        }
        arr[end] = arr[++lowPointer];
        arr[lowPointer] = pivot;
        return lowPointer;
    }
}
