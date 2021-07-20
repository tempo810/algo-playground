package leetcode;

import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeMap;

/**
 * @author Tempo
 */
public class HandOfStraight {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if (hand.length % groupSize != 0) {
            return false;
        }

        TreeMap<Integer, Integer> handMap = new TreeMap<>();
        for (int i : hand) {
            handMap.compute(i, (k, v) -> v == null ? 1 : v + 1);
        }
        while (!handMap.isEmpty()) {
            int offset = 1;
            Map.Entry<Integer, Integer> firstEntry = handMap.pollFirstEntry();
            while (offset < groupSize) {
                Integer currentValue = handMap.remove(firstEntry.getKey() + offset);
                if (currentValue == null || currentValue < firstEntry.getValue()) {
                    return false;
                }

                if (currentValue > firstEntry.getValue()) {
                    handMap.put(firstEntry.getKey() + offset, currentValue - firstEntry.getValue());
                }
                offset++;
            }
        }
        return true;
    }

    public boolean inNStraightHandPQ(int[] hand, int groupSize) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i : hand) {
            pq.offer(i);
        }
        while (!pq.isEmpty()) {
            Integer first = pq.poll();
            for (int i = 1; i < groupSize; i++) {
                if (!pq.remove(first + 1)) {
                    return false;
                }
            }
        }
        return true;
    }
}
