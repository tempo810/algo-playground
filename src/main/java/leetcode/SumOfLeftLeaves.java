package leetcode;

import leetcode.datastructure.TreeNode;

/**
 * @author Tempo
 */
public class SumOfLeftLeaves {
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return solveLeft(root.left) + solveRight(root.right);
    }

    private int solveLeft(TreeNode left) {
        if (left == null) {
            return 0;
        }
        if (left.left != null) {
            return solveLeft(left.left) + solveRight(left.right);
        } else {
            return left.right == null ? left.val : solveRight(left.right);
        }
    }

    private int solveRight(TreeNode right) {
        if (right == null) {
            return 0;
        }
        return solveLeft(right.left) + solveRight(right.right);
    }
}
