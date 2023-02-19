package leetcode;

import leetcode.datastructure.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author tempo
 */
public class BinaryTreeZigZagLevelOrderTransversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Deque<TreeNode> deque = new ArrayDeque<>();
        List<List<Integer>> result = new ArrayList<>();
        if (root != null) {
            boolean fromLeft = false;
            deque.add(root);
            while (!deque.isEmpty()) {
                int size = deque.size();
                List<Integer> currentLevel = new ArrayList<>();
                for (int i = 0; i < size; i++) {
                    final TreeNode node = fromLeft ? deque.pollFirst() : deque.pollLast();
                    currentLevel.add(node.val);
                    if (fromLeft) {
                        if (node.right != null) {
                            deque.addLast(node.right);
                        }
                        if (node.left != null) {
                            deque.addLast(node.left);
                        }
                    } else {
                        if (node.left != null) {
                            deque.addFirst(node.left);
                        }
                        if (node.right != null) {
                            deque.addFirst(node.right);
                        }
                    }
                }
                result.add(currentLevel);
                fromLeft = !fromLeft;
            }
        }

        return result;
    }
}
