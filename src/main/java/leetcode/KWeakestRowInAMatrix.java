package leetcode;

import java.util.PriorityQueue;

/**
 * @author Tempo
 */
public class KWeakestRowInAMatrix {
    public int[] kWeakestRows(int[][] mat, int k) {
        PriorityQueue<int[]> weakestRows = new PriorityQueue<>((o1, o2) -> {
            int diff = o2[0] - o1[0];
            if (diff != 0) return diff;
            else return o2[1] - o1[1];
        });


        for (int i = 0; i < mat.length; i++) {
            int soldiers = binaryCountOne(mat[i]);
            if (weakestRows.size() < k) {
                weakestRows.add(new int[]{soldiers, i});
            } else if (soldiers < weakestRows.peek()[0]) {
                int[] poll = weakestRows.poll();
                poll[0] = soldiers;
                poll[1] = i;
                weakestRows.add(poll);
            }
        }

        int[] result = new int[k];
        int i = k - 1;
        while (!weakestRows.isEmpty()) {
            result[i--] = weakestRows.poll()[1];
        }
        return result;
    }

    private int binaryCountOne(int[] row) {
        int lo = 0;
        int high = row.length - 1;
        while (lo < high) {
            int mid = (lo + high) / 2;
            if (row[mid] == 1) {
                lo = mid + 1;
            } else {
                high = mid;
            }
        }
        return lo;
    }
}
