package mit;

/**
 * @author tempo
 */
public class Heap {
    public static void maxHeapify(int[] arr, int index) {
        int largestIndex = index;
        if (2 * index <= arr.length && arr[(2 * index) - 1] > arr[largestIndex - 1]) {
            largestIndex = 2 * index;
        }
        if ((2 * index) + 1 <= arr.length && arr[2 * index] > arr[largestIndex - 1]) {
            largestIndex = (2 * index) + 1;
        }
        if (largestIndex != index) {
            int temp = arr[index - 1];
            arr[index - 1] = arr[largestIndex - 1];
            arr[largestIndex - 1] = temp;
            maxHeapify(arr, largestIndex);
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
        int smallestIndex = index;
        if (2 * index <= arr.length && arr[(2 * index) - 1] < arr[smallestIndex - 1]) {
            smallestIndex = 2 * index;
        }
        if ((2 * index) + 1 <= arr.length && arr[2 * index] < arr[smallestIndex - 1]) {
            smallestIndex = (2 * index) + 1;
        }
        if (smallestIndex != index) {
            int temp = arr[index - 1];
            arr[index - 1] = arr[smallestIndex - 1];
            arr[smallestIndex - 1] = temp;
            minHeapify(arr, smallestIndex);
        }
    }
}
