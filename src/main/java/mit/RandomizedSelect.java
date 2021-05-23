package mit;

import java.util.concurrent.ThreadLocalRandom;

/**
 * @author Tempo
 */
public class RandomizedSelect {
    public static int randomizedSelect(int[] arr, int p, int r, int i) {
        if (p == r) {
            return arr[p];
        }
        int q = randomizedPartition(arr, p, r);
        int k = q - p + 1;
        if (i == k) {
            return arr[q];
        }
        if (i < k) {
            return randomizedSelect(arr, p, q - 1, i);
        } else {
            return randomizedSelect(arr, q + 1, r, i - k);
        }
    }

    public static int randomizedSelectIterative(int[] arr, int p, int r, int i) {
        if (p == r) {
            return arr[p];
        }
        int q = randomizedPartition(arr, p, r);
        int k = q - p + 1;
        while (i != k) {
            if (i < k) {
                q = randomizedPartition(arr, p, q - 1);
            } else {
                q = randomizedPartition(arr, q + 1, r);
            }
            k = q - p + 1;
        }
        return arr[q];
    }

    private static int randomizedPartition(int[] arr, int p, int r) {
        int pivot = ThreadLocalRandom.current().nextInt(p, r + 1);
        int temp = arr[p];
        arr[p] = arr[pivot];
        arr[pivot] = temp;
        return partition(arr, p, r);
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
