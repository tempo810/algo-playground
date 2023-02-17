package leetcode;

import leetcode.datastructure.TreeNode;

/**
 * @author tempo
 */
public class MinimumDistanceBetweenBSTNodes {
    public int minDiffInBST(TreeNode root) {
        int diff = Integer.MAX_VALUE;
        if (root.left != null) {
            diff = root.val - findMax(root.left);
            diff = Math.min(diff, minDiffInBST(root.left));
        }
        if (root.right != null) {
            diff = Math.min(diff, findMin(root.right) - root.val);
            diff = Math.min(diff, minDiffInBST(root.right));
        }
        return diff;
    }

    private int findMin(TreeNode node) {
        while (node.left != null) {
            node = node.left;
        }
        return node.val;
    }

    private int findMax(TreeNode node) {
        while (node.right != null) {
            node = node.right;
        }
        return node.val;
    }
}
