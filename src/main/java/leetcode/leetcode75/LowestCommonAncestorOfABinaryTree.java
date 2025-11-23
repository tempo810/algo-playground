package leetcode.leetcode75;

import leetcode.datastructure.TreeNode;

/**
 * @author tempo
 */
public class LowestCommonAncestorOfABinaryTree {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        final TreeNode leftSeen = lowestCommonAncestor(root.left, p, q);
        final TreeNode rightSeen = lowestCommonAncestor(root.right, p, q);

        if (leftSeen != null && rightSeen != null) {
            return root;
        }

        if (root.val == p.val || root.val == q.val) {
            return root;
        }

        return leftSeen == null ? rightSeen : leftSeen;
    }

}
