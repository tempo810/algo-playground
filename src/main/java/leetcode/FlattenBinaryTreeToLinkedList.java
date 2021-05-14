package leetcode;

import leetcode.datastructure.TreeNode;

/**
 * @author Tempo
 */
public class FlattenBinaryTreeToLinkedList {
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        helper(root);
    }

    private TreeNode helper(TreeNode root) {
        if (root.left == null && root.right == null) {
            return root;
        }

        if (root.left != null) {
            TreeNode temp = root.right;
            root.right = root.left;
            root.left = null;
            TreeNode rightLeaf = helper(root.right);
            rightLeaf.right = temp;
            return rightLeaf.right == null ? rightLeaf : helper(rightLeaf.right);
        }
        return helper(root.right);
    }
}
