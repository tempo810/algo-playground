package leetcode;

import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * @author Tempo
 */
public class MinimumCostToConnectAllPoints {
    public int minCostConnectPoints(int[][] points) {
        Map<int[], PriorityQueue<Edge>> graph = new HashMap<>();
        Edge start = null;
        for (int i = 0; i < points.length - 1; i++) {
            for (int j = i + 1; j < points.length; j++) {
                Edge edge = new Edge(points[i], points[j]);
                if (start == null || start.cost() > edge.cost()) {
                    start = edge;
                }
                graph.computeIfAbsent(points[i], key -> new PriorityQueue<>(Comparator.comparing(Edge::cost))).add(edge);
                graph.computeIfAbsent(points[j], key -> new PriorityQueue<>(Comparator.comparing(Edge::cost))).add(edge);
            }
        }
        Set<int[]> pickedVertices = new HashSet<>();
        int cost = start.cost();
        pickedVertices.add(start.vertexA);
        pickedVertices.add(start.vertexB);
        while (pickedVertices.size() < points.length) {
            Edge nextMinCostEdge = null;
            for (int[] vertex : pickedVertices) {
                PriorityQueue<Edge> edges = graph.get(vertex);
                while (!edges.isEmpty()) {
                    Edge edge = edges.peek();
                    if (edge.vertexA != vertex ? pickedVertices.contains(edge.vertexA) : pickedVertices.contains(edge.vertexB)) {
                        edges.poll();
                    } else {
                        break;
                    }
                }
                Edge candidate = edges.peek();
                if (nextMinCostEdge == null || candidate != null && candidate.cost() < nextMinCostEdge.cost()) {
                    nextMinCostEdge = candidate;
                }
            }
            cost += nextMinCostEdge.cost();

            if (!pickedVertices.add(nextMinCostEdge.vertexA)) {
                pickedVertices.add(nextMinCostEdge.vertexB);
            }
        }
        return cost;
    }

    private static class Edge {
        final int[] vertexA;
        final int[] vertexB;

        private Edge(int[] vertexA, int[] vertexB) {
            this.vertexA = vertexA;
            this.vertexB = vertexB;
        }

        int cost() {
            return Math.abs(vertexA[0] - vertexB[0]) + Math.abs(vertexA[1] - vertexB[1]);
        }
    }
}
