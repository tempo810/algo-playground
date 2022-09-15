package leetcode;

import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

/**
 * @author tempo
 */
public class FindTheOriginalArray {
    public int[] findOriginalArray(int[] changed) {
        if (changed.length % 2 != 0) {
            return new int[]{};
        }
        NavigableMap<Integer, Integer> values = new TreeMap<>();
        for (int value : changed) {
            values.compute(value, (k, v) -> v == null ? 1 : v + 1);
        }
        int currentIndex = 0;
        int[] result = new int[changed.length / 2];

        if (values.firstKey() == 0) {
            Map.Entry<Integer, Integer> zeroEntry = values.pollFirstEntry();
            if (zeroEntry.getValue() % 2 != 0) {
                return new int[]{};
            }
            for (int i = 0; i < zeroEntry.getValue() / 2; i++, currentIndex++) {
                result[currentIndex] = 0;
            }
        }

        while (!values.isEmpty()) {
            Map.Entry<Integer, Integer> minOccurrence = values.pollFirstEntry();
            int targetKey = minOccurrence.getKey() * 2;
            int remaining = values.merge(targetKey, -minOccurrence.getValue(), Integer::sum);
            if (remaining < 0) {
                return new int[]{};
            }
            if (remaining == 0) {
                values.remove(targetKey);
            }
            for (int i = 0; i < minOccurrence.getValue(); i++, currentIndex++) {
                result[currentIndex] = minOccurrence.getKey();
            }
        }
        return result;
    }
}
