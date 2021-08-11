package leetcode;

import java.util.Map;
import java.util.TreeMap;

/**
 * @author Tempo
 */
public class ArrayOfDoublePairs {
    public boolean canReorderDoubled(int[] arr) {
        TreeMap<Integer, Integer> tree = new TreeMap<>();
        for (int i : arr) {
            tree.compute(i, (k, v) -> v == null ? 1 : v + 1);
        }
        while (!tree.isEmpty()) {
            Map.Entry<Integer, Integer> lowestEntry = tree.pollFirstEntry();
            if (lowestEntry.getKey() == 0) {
                if (lowestEntry.getValue() % 2 != 0) {
                    return false;
                }
            } else {
                int pairKey;
                if (lowestEntry.getKey() < 0) {
                    if (lowestEntry.getKey() % 2 != 0) {
                        return false;
                    }
                    pairKey = lowestEntry.getKey() / 2;
                } else {
                    pairKey = lowestEntry.getKey() * 2;
                }

                Integer pairValue = tree.get(pairKey);
                if (pairValue == null || pairValue < lowestEntry.getValue()) {
                    return false;
                }
                if (pairValue.equals(lowestEntry.getValue())) {
                    tree.remove(pairKey);
                } else {
                    tree.put(pairKey, pairValue - lowestEntry.getValue());
                }
            }
        }
        return true;
    }
}
