package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeMap;

/**
 * @author tempo
 */
public class AverageShuffle {
    public int[] advantageCount(int[] A, int[] B) {
        TreeMap<Integer, Integer> aTree = new TreeMap<>();
        TreeMap<Integer, List<Integer>> bTree = new TreeMap<>();
        for (int i = 0; i < A.length; i++) {
            aTree.compute(A[i], (k, v) -> v == null ? 1 : v + 1);
            bTree.computeIfAbsent(B[i], key -> new ArrayList<>()).add(i);
        }

        int[] result = new int[A.length];

        while (aTree.higherEntry(bTree.ceilingKey(0)) != null) {
            Map.Entry<Integer, List<Integer>> bLowestEntry = bTree.ceilingEntry(0);
            Map.Entry<Integer, Integer> aLowestEntry = aTree.higherEntry(bLowestEntry.getKey());
            Integer count = aLowestEntry.getValue();
            while (!bLowestEntry.getValue().isEmpty() && count > 0) {
                result[bLowestEntry.getValue().remove(0)] = aLowestEntry.getKey();
                count--;
            }
            if (count == 0) {
                aTree.remove(aLowestEntry.getKey());
            } else {
                aTree.put(aLowestEntry.getKey(), count);
            }
            if (bLowestEntry.getValue().isEmpty()) {
                bTree.remove(bLowestEntry.getKey());
            }
        }

        for (List<Integer> values : bTree.values()) {
            for (Integer index : values) {
                Map.Entry<Integer, Integer> firstEntry = aTree.ceilingEntry(0);
                result[index] = firstEntry.getKey();
                if (firstEntry.getValue() == 1) {
                    aTree.remove(firstEntry.getKey());
                } else {
                    aTree.put(firstEntry.getKey(), firstEntry.getValue() - 1);
                }
            }
        }
        return result;
    }

    public int[] advantageCountV2(int[] A, int[] B) {
        Arrays.sort(A);
        int[] result = new int[A.length];
        Arrays.fill(result, -1);
        PriorityQueue<Node> queue = new PriorityQueue<>(Comparator.comparingInt(node -> node.value));
        for (int i = 0; i < B.length; i++) {
            queue.add(new Node(B[i], i));
        }
        int index = 0;
        while (index < A.length && !queue.isEmpty()) {
            if (A[index] > queue.peek().value) {
                Node node = queue.remove();
                result[node.index] = A[index];
                A[index] = -1;
            }
            index++;
        }
        index = 0;
        for (int i = 0; i < result.length; i++) {
            if (result[i] == -1) {
                while (A[index] == -1) {
                    index++;
                }
                result[i] = A[index++];
            }
        }

        return result;
    }

    public static class Node {
        public final int value;
        public final int index;

        public Node(int value, int index) {
            this.value = value;
            this.index = index;
        }
    }
}
