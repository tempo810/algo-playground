package leetcode;

import leetcode.datastructure.TreeNode;

/**
 * @author tempo
 */
public class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return compare(root.right, root.left);
    }

    private boolean compare(TreeNode right, TreeNode left) {
        if (right == null || left == null) {
            return left == right;
        }

        if (right.val != left.val) {
            return false;
        }

        return compare(right.left, left.right) && compare(left.left, right.right);
    }
}
