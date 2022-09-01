package leetcode;

import leetcode.datastructure.TreeNode;

/**
 * @author tempo
 */
public class CountGoodNodesInABinaryTree {
    public int goodNodes(TreeNode root) {
        return count(root, Integer.MIN_VALUE);
    }

    private int count(TreeNode root, int maxValue) {
        if (root == null) {
            return 0;
        }
        if (root.val >= maxValue) {
            return 1 + count(root.left, root.val) + count(root.right, root.val);
        }
        return count(root.left, maxValue) + count(root.right, maxValue);
    }
}
