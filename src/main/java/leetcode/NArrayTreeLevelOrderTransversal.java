package leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * @author Tempo
 */
public class NArrayTreeLevelOrderTransversal {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root != null) {
            Queue<Node> nodes = new ArrayDeque<>();
            nodes.add(root);

            while (!nodes.isEmpty()) {
                List<Integer> levelResult = new ArrayList<>();
                for (int i = nodes.size(); i > 0; i--) {
                    Node node = nodes.remove();
                    levelResult.add(node.val);
                    nodes.addAll(node.children);
                }
                result.add(levelResult);
            }
        }

        return result;
    }

    class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    ;
}
