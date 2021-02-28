package mit;

import java.util.Arrays;

/**
 * @author Tempo
 */
public class CountInversion {
    public static int count(int[] arr) {
        int[] input = Arrays.copyOf(arr, arr.length);
        return countMerge(input, 0, input.length - 1);
    }

    private static int countMerge(int[] arr, int low, int high) {
        if (low >= high) {
            return 0;
        }

        int mid = (high + low) / 2;
        int mergedCount = countMerge(arr, low, mid) + countMerge(arr, mid + 1, high);
        int[] left = Arrays.copyOfRange(arr, low, mid + 1);
        int[] right = Arrays.copyOfRange(arr, mid + 1, high + 1);
        int l = 0;
        int r = 0;
        int current = low;
        while (l < left.length && r < right.length) {
            if (left[l] > right[r]) {
                arr[current++] = right[r++];
                mergedCount++;
            } else {
                arr[current++] = left[l++];
            }
        }
        if (r == right.length) {
            System.arraycopy(left, l, arr, current, left.length - l);
        }

        return mergedCount + left.length - l;
    }
}
