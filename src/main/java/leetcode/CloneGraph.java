package leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * @author Tempo
 */
public class CloneGraph {
    public Node cloneGraph(Node node) {
        Queue<Node> graph = new ArrayDeque<>();
        graph.add(node);
        Map<Integer, Node> cloned = new HashMap<>();

        while (!graph.isEmpty()) {
            Node originalNode = graph.remove();
            Node clonedNode = cloned.computeIfAbsent(originalNode.val, key -> new Node(originalNode.val));
            int expectedSize = originalNode.neighbors.size();

            for (int i = clonedNode.neighbors.size(); i < expectedSize; i++) {
                Node originalNeighbour = originalNode.neighbors.get(i);
                Node clonedNeighbour = cloned.get(originalNeighbour.val);
                if (clonedNeighbour == null) {
                    graph.add(originalNeighbour);
                } else {
                    clonedNode.neighbors.add(clonedNeighbour);
                }
            }

            if (clonedNode.neighbors.size() < originalNode.neighbors.size()) {
                graph.add(originalNode);
            }
        }
        return cloned.get(node.val);
    }

    static class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<>();
        }

        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<>();
        }

        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }
}
