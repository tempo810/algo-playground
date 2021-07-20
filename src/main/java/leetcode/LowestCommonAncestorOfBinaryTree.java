package leetcode;

import leetcode.datastructure.TreeNode;

/**
 * @author Tempo
 */
public class LowestCommonAncestorOfBinaryTree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        TreeNode leftFound = lowestCommonAncestor(root.left, p, q);
        if (root.val == p.val || root.val == q.val) {
            return root;
        }
        TreeNode rightFound = lowestCommonAncestor(root.right, p, q);
        if (leftFound != null && rightFound != null) {
            return root;
        }
        if (leftFound != null) {
            return leftFound;
        }
        return rightFound;
    }
}
