package mit;

/**
 * @author Tempo
 */
public class HeapSort {
    public static void heapSort(int[] arr) {
        Heap.buildMaxHeap(arr);
        for (int i = arr.length - 1; i >= 1; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            Heap.maxHeapify(arr, 1, i);
        }
    }
}
