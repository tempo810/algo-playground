package leetcode;

import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

/**
 * @author tempo
 */
public class SnapshotArray {
    private final NavigableMap<Integer, Integer>[] array;

    private int snapshotId;

    public SnapshotArray(int length) {
        array = new NavigableMap[length];
        for (int i = 0; i < length; i++) {
            array[i] = new TreeMap<>();
        }
        snapshotId = 0;
    }

    public void set(int index, int val) {
        array[index].put(snapshotId, val);
    }

    public int snap() {
        return ++snapshotId - 1;
    }

    public int get(int index, int snap_id) {
        final Map.Entry<Integer, Integer> entry = array[index].floorEntry(snap_id);
        return entry == null ? 0 : entry.getValue();
    }
}
