package leetcode;

import leetcode.datastructure.TreeNode;

/**
 * @author Tempo
 */
public class BinaryTreeMaxPathSum {
    public int maxPathSum(TreeNode root) {
        int[] result = find(root);
        return Math.max(result[0], result[1]);
    }

    private int[] find(TreeNode root) {
        int[] result = new int[2];
        if (root == null) {
            result[1] = Integer.MIN_VALUE;
            return result;
        }
        if (root.left == null && root.right == null) {
            result[0] = root.val;
            result[1] = result[0];
            return result;
        }

        int[] leftSub = find(root.left);
        int[] rightSub = find(root.right);
        int incompleteSubTree = root.val + Math.max(leftSub[0], rightSub[0]);
        int completeSubtreeSum = root.val + leftSub[0] + rightSub[0];
        result[0] = incompleteSubTree;
        result[1] = Math.max(completeSubtreeSum, Math.max(leftSub[1], rightSub[1]));
        return result;
    }
}
