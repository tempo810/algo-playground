package leetcode;

import java.util.Comparator;
import java.util.NavigableSet;
import java.util.TreeSet;

/**
 * @author tempo
 */
public class SmallestInfiniteSet {
    NavigableSet<Integer> minHeap = new TreeSet<>(Comparator.naturalOrder());
    int currentHead = 1;

    public SmallestInfiniteSet() {

    }

    public int popSmallest() {
        int val = !this.minHeap.isEmpty() ? this.minHeap.pollFirst() : this.currentHead++;
        return val;
    }

    public void addBack(int num) {
        if (num < this.currentHead) {
            this.minHeap.add(num);
        }
    }
}
