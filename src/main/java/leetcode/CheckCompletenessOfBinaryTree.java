package leetcode;

import leetcode.datastructure.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author tempo
 */
public class CheckCompletenessOfBinaryTree {
    public boolean isCompleteTree(TreeNode root) {
        Queue<TreeNode> nodes = new ArrayDeque<>();
        nodes.add(root);
        boolean hasNullNode = false;
        while (!nodes.isEmpty()) {
            int size = nodes.size();
            for (int i = 0; i < size; i++) {
                final TreeNode current = nodes.poll();
                if (current.left != null) {
                    if (hasNullNode) {
                        return false;
                    }
                    nodes.add(current.left);
                } else {
                    hasNullNode = true;
                }
                if (current.right != null) {
                    if (hasNullNode) {
                        return false;
                    }
                    nodes.add(current.right);
                } else {
                    hasNullNode = true;
                }
            }
        }
        return true;
    }
}
