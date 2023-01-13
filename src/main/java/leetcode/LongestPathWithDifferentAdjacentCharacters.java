package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author tempo
 */
public class LongestPathWithDifferentAdjacentCharacters {
    public int longestPath(int[] parent, String s) {

        List<Integer>[] adjacentEdges = new List[parent.length];
        for (int i = 0; i < parent.length; i++) {
            if (adjacentEdges[i] == null) {
                adjacentEdges[i] = new ArrayList<>();
            }
            if (parent[i] >= 0) {
                if (adjacentEdges[parent[i]] == null) {
                    adjacentEdges[parent[i]] = new ArrayList<>();
                }
                adjacentEdges[parent[i]].add(i);
                adjacentEdges[i].add(parent[i]);
            }
        }

        return findMax(adjacentEdges, 0, 0, s.toCharArray())[0];
    }

    private int[] findMax(List<Integer>[] adjacentEdges, int current, int parent, char[] characters) {
        int[] currentRootMaxPaths = new int[2];
        int globalMaxPath = 0;
        for (Integer adj : adjacentEdges[current]) {
            if (adj != parent) {
                int[] adjMax = findMax(adjacentEdges, adj, current, characters);
                if (characters[adj] != characters[current]) {
                    if (currentRootMaxPaths[0] < currentRootMaxPaths[1]) {
                        if (adjMax[1] > currentRootMaxPaths[0]) {
                            currentRootMaxPaths[0] = adjMax[1];
                        }
                    } else {
                        if (adjMax[1] > currentRootMaxPaths[1]) {
                            currentRootMaxPaths[1] = adjMax[1];
                        }
                    }
                }
                globalMaxPath = Math.max(globalMaxPath, adjMax[0]);
            }
        }
        return new int[]{Math.max(globalMaxPath, currentRootMaxPaths[0] + currentRootMaxPaths[1] + 1), 1 + Math.max(currentRootMaxPaths[0], currentRootMaxPaths[1])};
    }
}
