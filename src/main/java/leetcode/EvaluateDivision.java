package leetcode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Tempo
 */
public class EvaluateDivision {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, Map<String, Double>> graph = new HashMap<>();
        for (int i = 0; i < equations.size(); i++) {
            List<String> edge = equations.get(i);
            graph.computeIfAbsent(edge.get(0), key -> new HashMap<>()).put(edge.get(1), values[i]);
            graph.computeIfAbsent(edge.get(1), key -> new HashMap<>()).put(edge.get(0), 1 / values[i]);
        }

        double[] result = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            List<String> query = queries.get(i);
            Map<String, Double> initialEdge = graph.remove(query.get(0));
            if (initialEdge != null) {
                if (query.get(1).equals(query.get(0))) {
                    result[i] = 1;
                } else {
                    result[i] = find(1D, initialEdge, query.get(1), graph);
                }
                graph.put(query.get(0), initialEdge);
            } else {
                result[i] = -1;
            }
        }
        return result;
    }

    private double find(double currentValue, Map<String, Double> edges, String destination, Map<String, Map<String, Double>> graph) {
        if (edges.containsKey(destination)) return currentValue * edges.get(destination);
        for (Map.Entry<String, Double> edge : edges.entrySet()) {
            Map<String, Double> neighbour = graph.remove(edge.getKey());
            if (neighbour != null) {
                double answer = find(currentValue * edge.getValue(), neighbour, destination, graph);
                graph.put(edge.getKey(), neighbour);
                if (answer != -1D) {
                    return answer;
                }
            }
        }
        return -1D;
    }
}
