package leetcode.leetcode75;

import leetcode.datastructure.TreeNode;

/**
 * @author tempo
 */
public class DeleteNodeInBST {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        if (root.val == key) {
            TreeNode newRoot = root.right; // new root
            if (newRoot != null) {
                TreeNode detachedLeft = root.left;
                TreeNode lowestOfNewSubtree = newRoot;
                while (lowestOfNewSubtree.left != null) {
                    lowestOfNewSubtree = lowestOfNewSubtree.left;
                }
                lowestOfNewSubtree.left = detachedLeft;
            } else {
                newRoot = root.left;
            }
            return newRoot;
        } else if (root.val < key) {
            root.right = deleteNode(root.right, key);
        } else {
            root.left = deleteNode(root.left, key);
        }
        return root;
    }
}
