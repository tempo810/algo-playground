package leetcode;

import leetcode.datastructure.TreeNode;

/**
 * @author Tempo
 */
public class PruneTree {
    public TreeNode pruneTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        root.left = pruneTree(root.left);
        root.right = pruneTree(root.right);

        return root.val == 0 && root.left == null && root.right == null ? null : root;
    }
}
