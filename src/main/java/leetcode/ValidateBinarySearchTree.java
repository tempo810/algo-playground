package leetcode;

import leetcode.datastructure.TreeNode;

/**
 * @author tempo
 */
public class ValidateBinarySearchTree {
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isValid(root, null, null);
    }

    private boolean isValid(TreeNode node, Integer lowerBound, Integer upperBound) {
        if (node == null) {
            return true;
        }

        if ((lowerBound != null && node.val <= lowerBound) || (upperBound != null && node.val >= upperBound)) {
            return false;
        }

        return isValid(node.left, lowerBound, node.val) && isValid(node.right, node.val, upperBound);
    }
}
