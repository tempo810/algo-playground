package leetcode;

import leetcode.datastructure.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author Tempo
 */
public class CousinBinaryTree {
    public boolean isCousins(TreeNode root, int x, int y) {
        if (root == null || root.val == x || root.val == y) {
            return false;
        }

        Queue<TreeNode> nodes = new ArrayDeque<>();
        nodes.add(root);

        boolean found = false;
        while (!nodes.isEmpty() && !found) {
            int size = nodes.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = nodes.remove();
                if (node.val == x || node.val == y) {
                    if (found) {
                        return true;
                    } else {
                        found = true;
                    }
                }
                if (!isInvalid(node, x, y)) {
                    return false;
                }
                if (node.left != null) {
                    nodes.add(node.left);
                }
                if (node.right != null) {
                    nodes.add(node.right);
                }
            }
        }
        return false;
    }

    private boolean isInvalid(TreeNode root, int x, int y) {
        return root.left != null && root.right != null && (root.left.val == x || root.left.val == y) && (root.right.val == x || root.right.val == y);
    }
}
