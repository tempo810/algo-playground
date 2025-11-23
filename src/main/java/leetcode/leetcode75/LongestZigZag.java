package leetcode.leetcode75;

import leetcode.datastructure.TreeNode;

/**
 * @author tempo
 */
public class LongestZigZag {
    public int longestZigZag(TreeNode root) {
        return Math.max(count(1, root.left, true), count(1, root.right, false));
    }

    private int count(int currentDepth, TreeNode node, boolean isLeft) {
        if (node == null) {
            return currentDepth;
        }
        TreeNode zigZagNext = isLeft ? node.right : node.left;
        TreeNode sameDirection = isLeft ? node.left : node.right;
        return Math.max(count(currentDepth + 1, zigZagNext, !isLeft), count(1, sameDirection, isLeft));
    }
}
