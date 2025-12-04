package leetcode.top;

import leetcode.datastructure.Node;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author tempo
 */
public class PopulatingNextRightPointerInEachNode {
    public Node connect(Node root) {
        if (root == null) return null;
        Queue<Node> nodes = new ArrayDeque<>();
        nodes.add(root);
        while (!nodes.isEmpty()) {
            int size = nodes.size();
            for (int i = 0; i < size; i++) {
                final Node currentNode = nodes.poll();
                if (i < size - 1) {
                    currentNode.next = nodes.peek();
                }
                if (currentNode.left != null) {
                    nodes.add(currentNode.left);
                }
                if (currentNode.right != null) {
                    nodes.add(currentNode.right);
                }
            }
        }

        return root;
    }
}
