package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Tempo
 */
public class IsGraphBipartite {
    public boolean isBipartiteOptimized(int[][] graph) {
        int[] colours = new int[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (colours[i] == 0 && !isValid(i, graph, 1, colours)) {
                return false;
            }
        }
        return true;
    }

    private boolean isValid(int i, int[][] graph, int colour, int[] colours) {
        if (colours[i] != 0) {
            return colours[i] == colour;
        }
        colours[i] = colour;
        for (int neighbour : graph[i]) {
            if (!isValid(neighbour, graph, -colour, colours)) {
                return false;
            }
        }
        return true;
    }

    public boolean isBipartite(int[][] graph) {
        Set<Integer> setA = new HashSet<>();
        Set<Integer> setB = new HashSet<>();
        int neighbours = 0;
        for (int i = 0; i < graph.length; i++) {
            if (graph[i].length > 0) {
                if (!setA.contains(i) && !setB.contains(i) && !isBipartite(graph, i, setA, setB, true)) {
                    return false;
                }
                neighbours++;
            }
        }
        return neighbours == setA.size() + setB.size();
    }

    private boolean isBipartite(int[][] graph, int index, Set<Integer> setA, Set<Integer> setB, boolean useSetA) {
        Set<Integer> targetSet = useSetA ? setA : setB;
        Set<Integer> nonTargetSet = useSetA ? setB : setA;
        if (nonTargetSet.contains(index)) return false;
        if (!targetSet.add(index)) return true;
        for (int neighbour : graph[index]) {
            if (!isBipartite(graph, neighbour, setA, setB, !useSetA)) {
                return false;
            }
        }
        return true;
    }
}
