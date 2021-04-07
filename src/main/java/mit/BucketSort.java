package mit;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Tempo
 */
public class BucketSort {
    public static void sort(float[] arr) {
        List<Float>[] buckets = new List[arr.length];
        for (int i = 0; i < arr.length; i++) {
            buckets[i] = new ArrayList<>();
        }
        for (float v : arr) {
            buckets[(int) (v * arr.length)].add(v);
        }

        int index = 0;
        for (List<Float> bucket : buckets) {
            Collections.sort(bucket);
            for (Float val : bucket) {
                arr[index++] = val;
            }
        }
    }
}
