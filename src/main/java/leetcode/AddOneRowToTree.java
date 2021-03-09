package leetcode;

import leetcode.datastructure.TreeNode;

/**
 * @author tempo
 */
public class AddOneRowToTree {
    public TreeNode addOneRow(TreeNode root, int v, int d) {
        if (d == 1) {
            var node = new TreeNode(v);
            node.left = root;
            return node;
        }
        return add(root, v, 2, d);
    }

    private TreeNode add(TreeNode root, int value, int depth, int target) {
        if (root == null) {
            return null;
        }
        if (depth == target) {
            TreeNode lNode = new TreeNode(value);
            TreeNode rNode = new TreeNode(value);
            lNode.left = root.left;
            rNode.right = root.right;
            root.left = lNode;
            root.right = rNode;
            return root;
        } else {
            add(root.left, value, depth + 1, target);
            add(root.right, value, depth + 1, target);
        }
        return root;
    }
}
