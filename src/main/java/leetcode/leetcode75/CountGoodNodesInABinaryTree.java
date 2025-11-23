package leetcode.leetcode75;

import leetcode.datastructure.TreeNode;

/**
 * @author tempo
 */
public class CountGoodNodesInABinaryTree {
    public int goodNodes(TreeNode root) {
        return countOfGoodNodes(root, Integer.MIN_VALUE);
    }

    private int countOfGoodNodes(TreeNode root, int maxValueOfPath) {
        if (root == null) {
            return 0;
        }
        int nextMax = Math.max(root.val, maxValueOfPath);
        return (root.val >= maxValueOfPath ? 1 : 0) + countOfGoodNodes(root.left, nextMax) + countOfGoodNodes(root.right, nextMax);
    }
}
