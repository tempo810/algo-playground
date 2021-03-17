package mit;

/**
 * @author tempo
 */
public class QuickSort {
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
