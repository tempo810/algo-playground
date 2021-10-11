package leetcode;

import leetcode.datastructure.TreeNode;

/**
 * @author Tempo
 */
public class DiameterOfBinaryTree {
    private int currentMax = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        return Math.max(transverse(root), currentMax);
    }

    private int transverse(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftDepth = transverse(root.left);
        int rightDepth = transverse(root.right);
        currentMax = Math.max(currentMax, leftDepth + rightDepth + 1);
        return Math.max(leftDepth, rightDepth) + 1;
    }
}
