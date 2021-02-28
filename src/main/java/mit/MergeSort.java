package mit;

import java.util.Arrays;

/**
 * @author Tempo
 */
public class MergeSort {
    public static void mergeSort(int[] arr, int low, int high) {
        if (low < high) {
            mergeSort(arr, low, (low + high) / 2);
            mergeSort(arr, (low + high) / 2 + 1, high);
            int[] left = Arrays.copyOfRange(arr, low, (low + high) / 2 + 1);
            int[] right = Arrays.copyOfRange(arr, (low + high) / 2 + 1, high + 1);

            int l = 0;
            int r = 0;
            int current = low;
            while (l < left.length && r < right.length) {
                if (left[l] < right[r]) {
                    arr[current++] = left[l++];
                } else {
                    arr[current++] = right[r++];
                }
            }

            if (r == right.length) {
                System.arraycopy(left, l, arr, current, left.length - l);
            }
        }
    }
}
