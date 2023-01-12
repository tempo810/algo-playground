package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author tempo
 */
public class NumberOfNodesInSubtreeWithTheSameLabel {
    public int[] countSubTrees(int n, int[][] edges, String labels) {
        int[] result = new int[n];
        List<Integer>[] adjacentEdges = new List[n];
        for (int i = 0; i < n; i++) {
            adjacentEdges[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {
            adjacentEdges[edge[0]].add(edge[1]);
            adjacentEdges[edge[1]].add(edge[0]);
        }

        countLabel(0, adjacentEdges, labels.toCharArray(), 0, result);
        return result;
    }

    private int[] countLabel(int current, List<Integer>[] adjacentEdges, char[] characters, int parent, int[] result) {
        int[] count = new int[26];
        for (Integer index : adjacentEdges[current]) {
            if (index != parent) {
                int[] childrenLabels = countLabel(index, adjacentEdges, characters, current, result);
                for (int i = 0; i < 26; i++) {
                    count[i] += childrenLabels[i];
                }
            }
        }
        result[current] = ++count[characters[current] - 'a'];
        return count;
    }
}
