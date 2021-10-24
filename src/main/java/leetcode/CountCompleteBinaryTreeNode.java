package leetcode;

import leetcode.datastructure.TreeNode;

/**
 * @author Tempo
 */
public class CountCompleteBinaryTreeNode {
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int lDepth = 0, rDepth = 0;
        TreeNode cursor = root;
        while (cursor.left != null) {
            lDepth++;
            cursor = cursor.left;
        }
        cursor = root;
        while (cursor.right != null) {
            rDepth++;
            cursor = cursor.right;
        }

        if (lDepth == rDepth) {
            return (2 << lDepth) - 1;
        }
        return 1 + countNodes(root.left) + countNodes(root.right);
    }
}
