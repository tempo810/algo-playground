package mit;

/**
 * @author tempo
 */
public class Heap {
    public static void buildMaxHeap(int[] arr) {
        for (int i = arr.length / 2; i >= 1; i--) {
            maxHeapify(arr, i);
        }
    }

    public static void buildMinHeap(int[] arr) {
        for (int i = arr.length / 2; i >= 1; i--) {
            minHeapify(arr, i);
        }
    }

    public static void maxHeapify(int[] arr, int index) {
        maxHeapify(arr, index, arr.length);
    }

    public static void maxHeapify(int[] arr, int index, int end) {
        int largestIndex = index;
        if (2 * index <= end && arr[(2 * index) - 1] > arr[largestIndex - 1]) {
            largestIndex = 2 * index;
        }
        if ((2 * index) + 1 <= end && arr[2 * index] > arr[largestIndex - 1]) {
            largestIndex = (2 * index) + 1;
        }
        if (largestIndex != index) {
            int temp = arr[index - 1];
            arr[index - 1] = arr[largestIndex - 1];
            arr[largestIndex - 1] = temp;
            maxHeapify(arr, largestIndex, end);
        }
    }

    public static void maxHeapifyIterative(int[] arr, int index) {
        int largestIndex = index;
        while (largestIndex * 2 <= arr.length) {
            int currentLargest = largestIndex;

            if (arr[(2 * currentLargest) - 1] > arr[currentLargest - 1]) {
                currentLargest = 2 * currentLargest;
            }
            if ((2 * currentLargest) + 1 <= arr.length && arr[2 * currentLargest] > arr[currentLargest - 1]) {
                currentLargest = (2 * currentLargest) + 1;
            }
            if (currentLargest != largestIndex) {
                int temp = arr[largestIndex - 1];
                arr[largestIndex - 1] = arr[currentLargest - 1];
                arr[currentLargest - 1] = temp;
                largestIndex = currentLargest;
            } else {
                break;
            }
        }
    }

    public static void minHeapify(int[] arr, int index) {
        minHeapify(arr, index, arr.length);
    }

    public static void minHeapify(int[] arr, int index, int end) {
        int smallestIndex = index;
        if (2 * index <= end && arr[(2 * index) - 1] < arr[smallestIndex - 1]) {
            smallestIndex = 2 * index;
        }
        if ((2 * index) + 1 <= end && arr[2 * index] < arr[smallestIndex - 1]) {
            smallestIndex = (2 * index) + 1;
        }
        if (smallestIndex != index) {
            int temp = arr[index - 1];
            arr[index - 1] = arr[smallestIndex - 1];
            arr[smallestIndex - 1] = temp;
            minHeapify(arr, smallestIndex, end);
        }
    }
}
