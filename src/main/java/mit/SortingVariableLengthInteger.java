package mit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Tempo
 */
public class SortingVariableLengthInteger {
    @SuppressWarnings("unchecked")
    public static void sort(int[] arr, int n) {
        List<Integer>[] buckets = new List[n + 1];
        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = new ArrayList<>();
        }

        for (int j : arr) {
            buckets[countDigit(j)].add(j);
        }
        int count = 0;
        for (List<Integer> bucket : buckets) {
            if (!bucket.isEmpty()) {
                radixSort(bucket);
                for (Integer i : bucket) {
                    arr[count++] = i;
                }
            }
        }
    }

    private static void radixSort(List<Integer> bucket) {
        for (int exp = 1; bucket.get(0) / exp > 0; exp *= 10)
            countSort(bucket, exp);
    }

    private static void countSort(List<Integer> bucket, int exp) {
        int n = bucket.size();
        int[] output = new int[n]; // output array
        int i;
        int[] count = new int[10];
        Arrays.fill(count, 0);

        // Store count of occurrences in count[]
        for (i = 0; i < n; i++)
            count[(bucket.get(i) / exp) % 10]++;

        // Change count[i] so that count[i] now contains
        // actual position of this digit in output[]
        for (i = 1; i < 10; i++)
            count[i] += count[i - 1];

        // Build the output array
        for (i = n - 1; i >= 0; i--) {
            output[count[(bucket.get(i) / exp) % 10] - 1] = bucket.get(i);
            count[(bucket.get(i) / exp) % 10]--;
        }

        // Copy the output array to arr[], so that arr[] now
        // contains sorted numbers according to curent digit
        for (i = 0; i < n; i++)
            bucket.set(i, output[i]);
    }

    private static int countDigit(int n) {
        int remainder = n;
        int total = 0;
        while (remainder > 0) {
            total++;
            remainder /= 10;
        }
        return total;
    }
}
