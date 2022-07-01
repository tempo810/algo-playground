package leetcode;

import java.util.Arrays;

/**
 * @author Tempo
 */
public class QueueReconstructionByHeight {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (a, b) -> {
            int compare = Integer.compare(a[0], b[0]);
            if (compare == 0) {
                compare = Integer.compare(b[1], a[1]);
            }
            return compare;
        });
        BinaryIndexedTree indexedTree = new BinaryIndexedTree(people.length);
        int[][] result = new int[people.length][];
        for (int[] person : people) {
            int index = indexedTree.getIndex(person[1] + 1);
            result[index] = person;
            indexedTree.clear(index);
        }
        return result;
    }

    private static final class BinaryIndexedTree {
        private final int[] nodes;

        private BinaryIndexedTree(int index) {
            nodes = new int[index + 1];
            for (int i = 1; i < nodes.length; i++) {
                int currentIndex = i;
                while (currentIndex < nodes.length) {
                    nodes[currentIndex]++;
                    currentIndex += (currentIndex & -currentIndex);
                }
            }
        }

        private void clear(int index) {
            int currentIndex = index + 1;
            while (currentIndex < nodes.length) {
                nodes[currentIndex]--;
                currentIndex += (currentIndex & -currentIndex);
            }
        }

        private int getIndex(int val) {
            int low = 1;
            int high = nodes.length - 1;
            while (low <= high) {
                int mid = low + (high - low) / 2;
                if (get(mid) >= val) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
            return low - 1;
        }

        private int get(int mid) {
            int total = 0;
            while (mid > 0) {
                total += nodes[mid];
                mid -= (mid & -mid);
            }
            return total;
        }
    }
}
