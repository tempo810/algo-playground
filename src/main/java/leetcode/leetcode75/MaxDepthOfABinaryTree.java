package leetcode.leetcode75;

import leetcode.datastructure.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author tempo
 */
public class MaxDepthOfABinaryTree {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }

    public int maxDepthBfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> nodes = new ArrayDeque<>();
        nodes.add(root);
        int maxDepth = 0;
        while (!nodes.isEmpty()) {
            int currentDepthSize = nodes.size();
            for (int i = 0; i < currentDepthSize; i++) {
                final TreeNode node = nodes.poll();
                if (node.left != null) {
                    nodes.add(node.left);
                }
                if (node.right != null) {
                    nodes.add(node.right);
                }
            }
            maxDepth++;
        }
        return maxDepth;
    }
}
